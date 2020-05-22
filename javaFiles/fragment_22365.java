public class FunctionSample {
    static String fReturn() {
        return "Hello!";
    }
    static void fArgNoWorkie(String s) {
        s = "What am I doing???"; // Doesn't "work"! Java passes by value!
    }
    static void fMutate(StringBuilder sb) {
        sb.append("Here you go!");
    }
    public static void main(String[] args) {
        String s = null;

        s = fReturn();
        System.out.println(s); // prints "Hello!"

        fArgNoWorkie(s);
        System.out.println(s); // prints "Hello!"

        StringBuilder sb = new StringBuilder();
        fMutate(sb);
        s = sb.toString();
        System.out.println(s); // prints "Here you go!"
    }

}