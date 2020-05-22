public class BankData {

    private static final BankData INSTANCE = new BankData();

    // or make INSTANCE public, get rid of this method, and
    // use BankData.INSTNACE to access the instance
    public static BankData getInstance() {
        return INSTANCE;
    }

    // private constructor to stop any unwanted instantiations
    private BankData() {
        /* do any initialization */
    }

    // your other methods...

}