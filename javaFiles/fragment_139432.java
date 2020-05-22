public class Data{

    String adress;
    BigInteger AcNo;
    BigInteger mobile;
    String ifsc;

    void getData() {

        System.out.println("Welcome to  Bank System");

        System.out.println("Please Enter the adress :");
        adress = new Scanner(System.in).nextLine();

        System.out.println("Enter the Mobile Number");
        mobile = new Scanner(System.in).nextBigInteger();

        System.out.println("Enter the Account Number");
        AcNo = new Scanner(System.in).nextBigInteger();

        System.out.println("Enter the IFSC Code");
        ifsc = new Scanner(System.in).next();
    }

    public static void main(String[] args) {
        Data d = new Data();
        d.getData();
    }
}