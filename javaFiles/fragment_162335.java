public class Property {

    private int id;
    private String address;
    private String firstName;
    private String lastName;
    private String email;
    private String ownerContactAddress;
    private BigDecimal price;
    private java.sql.Date dateSold;

    public Property() {
    } 

    // Setters and getters
    public long getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = Long.parseLong(id);
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    // TODO: setter/getters for firstName, lastName, email, ownerContactAddress

    public BigDecimal getPrice() {
        return this.price;
    }
    public void setPrice(String price, Locale locale) throws ParseException {
        NumberFormat format = NumberFormat.getNumberInstance(locale);
        if (format instanceof DecimalFormat) {
            ((DecimalFormat) format).setParseBigDecimal(true);
        }
        this.price = (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]",""));
    }
    public java.sql.Date getDateSold() {
        return this.dateSold;
    }
    public void setDateSold(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        this.dateSold = new Date(sdf.parse(date).getTime());
    }
}