public class Main {

    @EJB
    public static AManagerRemote amr;

    public static void main(String[] args) {
         ......
         System.out.println(amr.returnFine());
         // ALWAYS RETURN 0