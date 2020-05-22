public class Ncr {
    public static void main (String[] args) {
        int nCrValues;

        System.out.println("Enter amount of nCr values you wish to calculate: ");
        nCrValues = input();

        while ((nCrValues < 2) || (nCrValues > 10)){
            System.out.println("Must be between 2 and 12 inclusive");
            nCrValues = input();
        }//END while
        for (int[] res : values(nCrValues)) {
            System.out.println(String.format("%d | %d | %d", res[0], res[1], res[2]));
        }
    }//END main

    public static int[][] values(int nCrValues){

        //I know I need a loop to nCrValues to input 'n' and 'r' as an array, not sure how
        int[][] res = new int[nCrValues][3];
        for (int i = 0; i < nCrValues; i++) {
            int n, r;

            System.out.println("Enter n value: ");
            n = input();
            System.out.println("Enter r value: ");
            r = input();

            res[i] = new int[]{n, r, calculatenCr(n, r)};
        }
        return res;
    }//END values

    public static int calculatenCr(int n, int r){
        return fact(n) / (fact(n-r) * fact(r));
    }//END calculatenCr

    public static int fact(int num){
        int count;
        int factor = 1;

        for (count = 1; count <= num; count++){
            factor *= count;
        }//END for
        return factor;
    }//END fact

    public static int input(){
        int input;

        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();

        while (input < 0){
            System.out.println("Must be a positive number.");
            input = sc.nextInt();
        }//END while
        return input;
    }//END input
}//END CLASS