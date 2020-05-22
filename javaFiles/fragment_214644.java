import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    static class Listener extends CalculatorBaseListener {

        @Override
        public void enterCalculate(CalculatorParser.CalculateContext ctx) {
            System.out.println("Calculate");
        }

        @Override
        public void enterToMultOrDiv(CalculatorParser.ToMultOrDivContext ctx) {
            System.out.println("ToMultOrDiv");
        }

        @Override
        public void enterToPow(CalculatorParser.ToPowContext ctx) {
            System.out.println("ToPow");
        }

        @Override
        public void enterPower(CalculatorParser.PowerContext ctx) {
            System.out.println("Power");
        }

        @Override
        public void enterToAtom(CalculatorParser.ToAtomContext ctx) {
            System.out.println("ToAtom");
        }

        @Override
        public void enterInt(CalculatorParser.IntContext ctx) {
            System.out.println("Int");
        }
    }

    public static void main(String[] args) {
        CalculatorLexer lexer = new CalculatorLexer(CharStreams.fromString("5"));
        CalculatorParser parser = new CalculatorParser(new CommonTokenStream(lexer));
        ParseTreeWalker.DEFAULT.walk(new Listener(), parser.input());
    }
}