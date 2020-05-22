public class StringPlus {

    public static void main(String[] args) {
        String  test="This is a simple text";
        for(char c: test.toCharArray()){
            System.out.print((c == ' ') ? " ":"+");
        }
    }
}