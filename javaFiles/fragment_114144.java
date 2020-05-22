public class TimeAndExpense {
    private final String jobCode;
    // and a bunch of other attributes such as department...

    // Then the additional data (approval data)
    private final Optional<String> approverId;
    private final Optional<Timestamp> approveTime;

    public TimeAndExpense(final String jobCode) {
        this(jobCode, null, null);
    }

    public TimeAndExpense(
                final String jobCode, 
                final Timestamp approveTime, 
                final String approverId) {

        this.jobCode = jobCode;
        // And the rest of the attributes...

        this.approveTime = Optional.ofNullable(approveTime);
        this.approverId = Optional.ofNullable(approverId);
    }

    public Optional<Timestamp> getApproveTime() {
        return approveTime;
    }

    public Optional<String> getApproverId() {
        return approverId;
    }

    public String getJobCode() {
        return jobCode;
    }

    public boolean isApproved() {
        return approverId.isPresent();
    }

    // Creates a new object with the approval data (immutable)
    public TimeAndExpense withApprovalData(final Timestamp approveTime, final String approverId) {
        return new TimeAndExpense(this.getJobCode(), approveTime, approverId);
    }
}