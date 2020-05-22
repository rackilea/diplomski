public class caesarCypher {

    static String inp;

    public static void main(String[] args) {
        int input;
        Scanner scan = new Scanner(System.in);
        inp = scan.nextLine();
        char[] inpArr = inp.toCharArray();

        input = inp.length();
        System.out.println(input + inp);
        for( int i = 0; i < input; i++)
        {
            inpArr[i] -= 12;
        }

        inp = new String( inpArr);
    }
}