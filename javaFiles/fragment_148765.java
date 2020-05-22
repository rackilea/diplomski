public class Math {
    void Book1(char a, char b) {
        String str=String.valueOf(a)+String.valueOf(b);        
        System.out.println("Output is: " + str);
    }

    public static void main(String[] args) {
        Math m = new Math();
        m.Book1('A', 'B');
    }
}