import java.util.Scanner;

public class SomeClass {

    protected Scanner scan;

    public SomeClass(String s) {
        scan = new Scanner(s);
    }

    public void getone() {

        if (scan.hasNext()){
            String temp = scan.next();
            temp = temp.replaceAll("[\\[\\](){}]","");
            System.out.println(temp);
        }

    }

    public static void main(String[] args) {

        String s = "(abcd) (defg) (w)";
        SomeClass test = new SomeClass(s);
        Scanner rando = new Scanner(s);
        System.out.println(rando.next());
        System.out.println(rando.hasNext());

        test.getone();

    }

}