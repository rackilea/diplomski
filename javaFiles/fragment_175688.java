public class Customer {

    private BigDecimal rentalSum = BigDecimal.ZERO;

    public void addRental(Rental rental) {
        rentalSum = rentalSum.add(rental.getPrice());
    }

    public BigDecimal sumRentals() {
        return rentalSum;
    }
}