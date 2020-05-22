public class className{
    public static void methodName1(Object atr1, Object atr2, Object atr3){
        encapsulation1(atr1, atr2, atr3);
        executeASingleInstruction();
        encapsulation2(atr1, atr2, atr3);
    }


    public static void methodName2(Object atr1, Object atr2, Object atr3){
        encapsulation1(atr1, atr2, atr3);
        // no execution of aforementioned instruction
        encapsulation2(atr1, atr2, atr3);
    }
}