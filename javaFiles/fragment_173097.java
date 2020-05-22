public class Coupon {

    private Date dueDate;

    private Integer periodDays;

    public Date getExpirationDate() { // name this whatever makes sense

        // assuming you can guarantee that one and only one is null == mutually exclusive
        return (dueDate != null) ? dueDate : DateUtils.addDays(new Date(), periodDays);
    }
}