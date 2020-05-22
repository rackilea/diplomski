import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.pattern.ParseTreeMatch;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;

import java.util.List;

public class Main {

  public static void main(String[] args) {

    String source = "package sampleCodes;\n" +
            "\n" +
            "public class fruits {\n" +
            "\n" +
            "  static { int q = 42; }\n" +
            "\n" +
            "  public static void main(String[] args){\n" +
            "    int a = 10;\n" +
            "    System.out.println(a);\n" +
            "  }\n" +
            "}\n";

    JavaLexer lexer = new JavaLexer(CharStreams.fromString(source));
    JavaParser parser = new JavaParser(new CommonTokenStream(lexer));
    ParseTree tree = parser.compilationUnit();

    ParseTreePattern p = parser.compileParseTreePattern("<IDENTIFIER> = <expression>", JavaParser.RULE_variableDeclarator);
    List<ParseTreeMatch> matches = p.findAll(tree, "//variableDeclarator");

    for (ParseTreeMatch match : matches) {
      System.out.println("\nMATCH:");
      System.out.printf(" - IDENTIFIER: %s\n", match.get("IDENTIFIER").getText());
      System.out.printf(" - expression: %s\n", match.get("expression").getText());
    }
  }
}