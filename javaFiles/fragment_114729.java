public class InvalidFormatting extends java.lang.Throwable
{
    /** The underlying error of this instance */
    public final static String Error = "An invalid format has been detected";

    /** Create a new {@code InvalidFormatting} exception */
    public InvalidFormatting() {
        super(InvalidFormatting.Error);
    }

    /**
     * Create a new {@code InvalidFormatting} exception with additional information
     *
     * @param additionalMsg The additional information to append
     */
    public InvalidFormatting(String additionalMsg) {
        super(InvalidFormatting.Error + "\n" + additionalMsg);
    }
}