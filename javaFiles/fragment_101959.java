public class QuotaLimitChecker {

    private final static Logger log = LogManager.getLogger(QuotaLimitChecker.class);

    private final int userQuotaLimit;
    //here is specific implementation of Meter for your needs
    private final InstanceLoadMeter quotaMeter;

    public QuotaLimitChecker(int userQuotaLimit) {
        this.userQuotaLimit = userQuotaLimit;
        this.quotaMeter = new InstanceLoadMeter();
    }

    public boolean quotaReached() {
        if (quotaMeter.getOneMinuteRate() > userQuotaLimit) {
            log.debug("User has exceeded message quota limit.");
            return true;
        }
        quotaMeter.mark();
        return false;
    }

}