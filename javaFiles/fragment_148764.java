public class Math {
    void Book1(char a, char b) {
        StringBuilder sb=new StringBuilder();
        sb.append(a);
        sb.append(b);
        System.out.println("Output is: " + sb.toString());
    }

    public static void main(String[] args) {
        Math m = new Math();
        m.Book1('A', 'B');
    }
}