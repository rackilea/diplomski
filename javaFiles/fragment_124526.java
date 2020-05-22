import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    String source = "int array[] = {1, 2};";

    GaleugParserNewLexer lexer = new GaleugParserNewLexer(CharStreams.fromString(source));
    GaleugParserNewParser parser = new GaleugParserNewParser(new CommonTokenStream(lexer));

    Value value = new EvalVisitor().visit(parser.declare_var());

    System.out.println(value);
  }
}

class Value {

  final Object value;

  public Value(Object value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }
}

class EvalVisitor extends GaleugParserNewBaseVisitor<Value> {

  @Override
  public Value visitDeclare_var(GaleugParserNewParser.Declare_varContext ctx) {
    List<Value> numbers = new ArrayList<>();
    if (ctx.array_init() != null) {
      for (TerminalNode tokenNode : ctx.array_init().INT()) {
        numbers.add(new Value(Integer.valueOf(tokenNode.getText())));
      }
    }
    return new Value(numbers);
  }
}