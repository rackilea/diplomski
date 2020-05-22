import com.sun.source.tree.Scope;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import static javax.lang.model.element.ElementKind.*;
import javax.lang.model.element.Name;
import javax.lang.model.util.Elements;
import org.apache.commons.lang3.StringUtils;

public class ScopeUtils {
    private Elements elements;

    public ScopeUtils(Elements elements) {
        this.elements = elements;
    }

    public Name generateUniqueName(Scope scope, CharSequence prefixCs) {
        String prefix = prefixCs.toString(); // https://issues.apache.org/jira/browse/LANG-786
        int i = 0, j = 0;

        Scope enclosingScope;
        for (; scope != null && (enclosingScope = scope.getEnclosingScope()) != null; scope = enclosingScope) {
            for (Element e : scope.getLocalElements()) {
                ElementKind kind = e.getKind();
                String simpleName = e.getSimpleName().toString();
                if (kind == LOCAL_VARIABLE ||
                        kind == PARAMETER ||
                        kind == EXCEPTION_PARAMETER ||
                        kind == TYPE_PARAMETER ||

                        kind == CLASS ||
                        kind == INTERFACE ||
                        kind == ENUM ||
                        kind == ANNOTATION_TYPE) {
                    if (StringUtils.startsWith(simpleName, prefix)) {
                        if (StringUtils.equals(simpleName, prefix)) {
                            i = Math.max(i, j + 1);
                        } else {
                            try {
                                j = Math.max(j, Integer.parseInt(simpleName.subSequence(prefix.length(), simpleName.length()).toString(), 10));
                            } catch (NumberFormatException ex) {
                                continue;
                            }

                            if (i > 0) {
                                i = Math.max(i, j + 1);
                            }
                        }
                    }
                } else {
                    assert kind == FIELD && (StringUtils.equals(simpleName, "super") || StringUtils.equals(simpleName, "this"));
                }
            }
        }

        return elements.getName(i <= 0 ? prefix : String.format("%s%d", prefix, i));
    }
}