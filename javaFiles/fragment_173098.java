public class UserCoupon {

    private Date dueDate;

    public UserCoupon(User user, Coupon coupon) {

        dueDate = coupon.getExpirationDate();
    }
}