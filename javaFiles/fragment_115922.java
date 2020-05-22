public class task_4 {
    public static void main(String[] args) {
        double cent = 10;
        double fahr = 10;

        double centToFahrResult = centToFahr(10);
        double fahrToCentResult = fahrToCent(20);

        System.out.println(fahrToCentResult + " " + centToFahrResult);
    }

    public static double fahrToCent(double fahr) {
        double cent;
        cent = ((fahr - 32) / 1.8);
        return cent;
    }
//}  <<<< this one should not be there

    public static double centToFahr(double cent) {
        double fahr;
        fahr = ((cent * 1.8) + 32);
        return fahr;
    }
//}  <<<< nor this one   
}