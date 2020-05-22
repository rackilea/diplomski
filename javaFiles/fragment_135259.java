import java.util.function.BinaryOperator;

public class Test {

    public static void main(String[] args) {
        Str myHello = (message1, message2) ->
                        System.out.println("Hello " + message1 + message2);
        myHello.welcome("Mr. ", "rickroll");

        example(Integer::sum, "2+3+4+5 = ", 2, 3, 4, 5);
        example(String::concat, "A.....gl ?", "b", "c", "d", "e", "f");
    }
    private static <E> void example(BinaryOperator<E> plus, String head, E... values) {
        MyGen<E,E> addition = args -> {
            E sum=args[0];
            for(int ix=1; ix<args.length; ix++) sum = plus.apply(sum, args[ix]);
            return sum;
        };
        System.out.println(head + Test.operate(addition, values));
    }
    private static <T,U> T operate(MyGen<T,U> choice, U... args) {
        return choice.asYouWish(args);
    }
    interface Str {
        public void welcome(String a, String b);
    }
    interface MyGen<X,Y> {
        public X asYouWish(Y... args);
    }
}