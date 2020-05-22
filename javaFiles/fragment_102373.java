import java.util.Scanner;

//Currency Converter

public class Vjezbica {

    public static void main(String[] args) {
        double e = 7.5;
        double d = 6.3;
        double p = 9.5;
        double k = 1.0;
        Conv more = new Conv();
        Scanner in = new Scanner(System.in);

        System.out.print("\t\tCurrency converter\nIz (e,p,d,k) - ");
        String iz = in.next();
        switch (iz) {
            case "e":
                more.PretvorbaInKunu(e);
                break;
            case "d":
                more.PretvorbaInKunu(d);
                break;
            case "p":
                more.PretvorbaInKunu(p);
                break;
            case "k":
                more.PretvorbaInKunu(k);
                break;
        }
        System.out.println(more.getRez2());

        System.out.print(" To  ");
        String u = in.next();
        switch (u) {
            case "e":
                more.PR2(e);
                break;//added break here
            case "d":
                more.PR2(d);
                break;//added break here
            case "p":
                more.PR2(p);
                break;//added break here
            case "k":
                more.PR2(k);
                break;//added break here
        }
        System.out.println(more.getSvota() + " " + iz + " is " + more.getRez() + " " + u);

        //you should also close the scanner at the end...
        in.close();
    }
}