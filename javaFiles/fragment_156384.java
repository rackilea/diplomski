private String getTXStatus()
{
    int txStatus = this.txReg.getTransactionStatus();
    switch (txStatus)
    {
        case Status.STATUS_ACTIVE:
            return "STATUS_ACTIVE";
        case Status.STATUS_COMMITTED:
            return "STATUS_COMMITTED";

        case Status.STATUS_COMMITTING:
            return "STATUS_COMMITTING";
        case Status.STATUS_MARKED_ROLLBACK:
            return "STATUS_MARKED_ROLLBACK";
        case Status.STATUS_NO_TRANSACTION:
            return "STATUS_NO_TRANSACTION";
        case Status.STATUS_PREPARED:
            return "STATUS_PREPARED";
        case Status.STATUS_PREPARING:
            return "STATUS_PREPARING";
        case Status.STATUS_ROLLEDBACK:
            return "STATUS_ROLLEDBACK";
        case Status.STATUS_ROLLING_BACK:
            return "STATUS_ROLLING_BACK";
        case Status.STATUS_UNKNOWN:
            return "STATUS_UNKNOWN";
        default:
            return "Unknown(" + txStatus + ")";
    }