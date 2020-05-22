import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import com.sun.codemodel.CodeWriter;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.writer.SingleStreamCodeWriter;

public class CodeModelToStringTest
{
    public static void main(String[] args) throws Exception
    {
        JCodeModel codeModel = new JCodeModel();
        JDefinedClass definedClass = codeModel._class("com.example.Example");

        definedClass.field(JMod.PUBLIC, String.class, "exampleString");
        definedClass.field(JMod.PROTECTED, int.class, "exampleInt");
        definedClass.field(JMod.PRIVATE, float.class, "exampleFloat");

        definedClass.field(JMod.PRIVATE, String.class, "excludedString");
        definedClass.field(JMod.STATIC, String.class, "staticString");

        createToStringMethod(definedClass, Arrays.asList("excludedString"));

        CodeWriter codeWriter = new SingleStreamCodeWriter(System.out);
        codeModel.build(codeWriter);
    }

    private static void createToStringMethod(
        JDefinedClass definedClass,
        Collection<String> excludedFieldNames)
    {
        Map<String, JFieldVar> fields = definedClass.fields();
        JMethod toString =
            definedClass.method(JMod.PUBLIC, String.class, "toString");
        toString.annotate(Override.class);

        JBlock body = toString.body();

        JExpression expression = JExpr.lit(definedClass.name() + " [");

        boolean first = true;
        for (JFieldVar fieldVar : fields.values())
        {
            if ((fieldVar.mods().getValue() & JMod.STATIC) == JMod.STATIC)
            {
                continue;
            }
            if (excludedFieldNames.contains(fieldVar.name()))
            {
                continue;
            }
            if (!first)
            {
                expression = expression.plus(JExpr.lit(", "));
            }
            expression = expression.plus(JExpr.lit(fieldVar.name()+" = "));
            expression = expression.plus(JExpr.ref(fieldVar.name()));
            first = false;
        }
        expression = expression.plus(JExpr.lit("]"));

        body._return(expression);


    }
}