import java.util.ArrayList; import java.util.Scanner;

public class wordMetaMorphism {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> input = new ArrayList<String>();

    while(sc.hasNext()) {
        String s = sc.next();
        if(s.equals("#")) break;
        input.add(s);
    }
    System.out.println(input);
}

}