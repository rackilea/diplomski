import java.util.*;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.ast.*;

public class VarFinder {
  public static void main(String[] args) throws IOException {
    final Set<String> names = new HashSet<String>();
    class Visitor implements NodeVisitor {
      @Override public boolean visit(AstNode node) {
        if (node instanceof Name) {
          names.add(node.getString());
        }
        return true;
      }
    }
    String script = "(V1ND < 0 ? Math.abs(V1ND) : 0)";
    AstNode node = new Parser().parse(script, "<cmd>", 1);
    node.visit(new Visitor());
    System.out.println(names);
  }
}