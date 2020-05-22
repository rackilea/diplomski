import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String source = "var a = 1; function foo() { var b = 2; } var c = 3;";
        ANTLRStringStream in = new ANTLRStringStream(source);
        JavaScriptLexer lexer = new JavaScriptLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaScriptParser parser = new JavaScriptParser(tokens);
        JavaScriptParser.program_return returnValue = parser.program();
        CommonTree tree = (CommonTree)returnValue.getTree();
        for(Object o : tree.getChildren()) {
            CommonTree child = (CommonTree)o;
            if(child.getType() == JavaScriptParser.VARIABLE) {
                System.out.println("Found a global var: "+child.getChild(0));
            }
        }
    }
}