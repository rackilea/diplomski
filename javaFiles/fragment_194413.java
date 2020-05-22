public class OperatorTest {

    public static void main(String[] args){
        System.out.println("Logical Operator:");
        if(sayAndReturn(true, "first") || sayAndReturn(true, "second")){
            //doNothing
        }

        System.out.println("Bitwise Operator:");
        if(sayAndReturn(true, "first") | sayAndReturn(true, "second")){
            //doNothing
        }
    }

    public static boolean sayAndReturn(boolean ret, String msg){
        System.out.println(msg);
        return ret;
    }
}