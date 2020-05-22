public class FalseIsTrue {
    public static void main(String[] args) {
        if ( false == true ) { //these characters are magic: \u000a\u007d\u007b
            System.out.println("false is true!");
        }
    }
}