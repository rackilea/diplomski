public class TaxBracket {
    public static final int SINGLE = 1;
    public static final int MARRIED = 2;
    public static final int HEAD_OF_HOUSE = 3;

    public final int mStatus;
    public final int minSalary;
    public final int maxSalary;
    public final double rate;

    public TaxBracket(int mStatus, int minSalary, int maxSalary, double rate) {
        this.mStatus = mStatus;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.taxRate = taxRate;
    }
}