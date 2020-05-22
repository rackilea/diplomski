public class PremiumRoom extends Room {

    private int freeNights;
    private double discountRate;
    private double nextBookingDiscountVoucher;

    public PremiumRoom(String roomId, String description, double dailyRate, int freeNights, double discountRate, double nextBookingDiscountVoucher) {
        super(roomId, description, dailyRate);
        this.freeNights = freeNights;
        this.discountRate = discountRate;
        this.nextBookingDiscountVoucher = nextBookingDiscountVoucher;
    }

    public void print() {
        super.print();
        StringBuilder str = new StringBuilder();

        str.append("Free Nights: ").append(freeNights).append("\n")
                .append("Discount Rate: ").append(discountRate).append("\n")
                .append("Voucher: ").append(nextBookingDiscountVoucher);

        System.out.println(str.toString());
    }
}