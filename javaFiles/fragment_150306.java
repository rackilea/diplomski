public class CreditCard {
    public static class ExpirationDate {
        private String month;
        private String year;

        // getters, setter

        @Override
        public String toString() {
            return month + "/" + year;
        }
    }

    private String type;
    private String cardNumber;
    private String name;
    private String securityCode;
    private ExpirationDate expirationDate;
    private String firstFourDigit;
    private String secondFourDigit;
    private String thirdFourDigit;
    private String lastFourDigits;
    private String zipCode;

    public void setExpirationDate(ExpirationDate expDate){
        this.expirationDate = expDate;
    }

    public ExpirationDate getExpirationDate(){
        return this.expirationDate;
    }

    // other getters, setters
}