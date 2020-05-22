import org.antlr.v4.runtime.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {

    String source = "int array[] = { 123456789, (1 + 2), Q };";

    GaleugParserNewLexer lexer = new GaleugParserNewLexer(CharStreams.fromString(source));
    GaleugParserNewParser parser = new GaleugParserNewParser(new CommonTokenStream(lexer));

    Map<String, Value> memory = new HashMap<String, Value>(){{
      put("Q", new Value(42));
    }};

    Value value = new EvalVisitor(memory).visit(parser.declare_var());

    System.out.println(value);
  }
}

class Value {

  final Object value;

  public Value(Object value) {
    this.value = value;
  }

  int asInt() {
    return (Integer) value;
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }
}

class EvalVisitor extends GaleugParserNewBaseVisitor<Value> {

  final Map<String, Value> memory;

  EvalVisitor(Map<String, Value> memory) {
    this.memory = memory;
  }

  @Override
  public Value visitDeclare_var(GaleugParserNewParser.Declare_varContext ctx) {
    List<Value> numbers = new ArrayList<>();
    if (ctx.array_init() != null) {
      for (GaleugParserNewParser.ExprContext expr : ctx.array_init().expr()) {
        numbers.add(super.visit(expr));
      }
    }
    return new Value(numbers);
  }

  @Override
  public Value visitIntExpr(GaleugParserNewParser.IntExprContext ctx) {
    return new Value(Integer.valueOf(ctx.getText()));
  }

  @Override
  public Value visitAddExpr(GaleugParserNewParser.AddExprContext ctx) {
    return new Value(super.visit(ctx.lhs).asInt() + super.visit(ctx.rhs).asInt());
  }

  @Override
  public Value visitNestedExpr(GaleugParserNewParser.NestedExprContext ctx) {
    return super.visit(ctx.expr());
  }

  @Override
  public Value visitIdExpr(GaleugParserNewParser.IdExprContext ctx) {
    return this.memory.get(ctx.getText());
  }
}