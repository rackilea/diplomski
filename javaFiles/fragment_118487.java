package test.parsingjava;

import java.io.StringReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import test.schyntax.parsing.ErrorListener;

public class ParsingJava {

    public static void main(String[] args) throws Exception {
        String expression="class test { public void method() {}}";
        StringReader reader= new StringReader(expression);
        ANTLRInputStream input = new ANTLRInputStream(reader);
        JavaLexer lexer= new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser= new JavaParser(tokens);
        parser.removeErrorListeners(); // remove ConsoleErrorListener
        parser.addErrorListener(new ErrorListener());
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker(); 
        // Walk the tree created during the parse, trigger callbacks 
        JavaListener listener=new JavaBaseListener();
        walker.walk(listener, tree);
    }

}