public class Test<T,U> {

    public static void main(String[] args) {
        Str myHello = (message1, message2) ->
                        System.out.println("Hello " + message1 + message2);
        myHello.welcome("Mr. ", "rickroll");

        {
            Test<Integer,Integer> myTest = new Test();
            MyGen<Integer,Integer> addition = operationArgs -> {
                int sum = 0;
                for(int i: operationArgs) sum += i;
                return sum;
            };
            System.out.println("2+3+4+5 = " + myTest.operate(addition, 2, 3, 4, 5));
        }
        {
            Test<String,String> myTest = new Test();
            MyGen<String,String> addition = operationArgs -> {
                String sum = "";
                for(String i: operationArgs) sum += i;
                return sum;
            };
            System.out.println("A.....gl ?"
                + myTest.operate(addition, "b", "c", "d", "e", "f"));
        }
    }
    private T operate(MyGen<T,U> choice, U... args) {
        return choice.asYouWish(args);
    }
    interface Str {
        public void welcome(String a, String b);
    }
    interface MyGen<X,Y> {
        public X asYouWish(Y... args);
    }
}