@Entity
public class Price {
    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String price;

    @ManyToOne
    @JoinColumn(name = "past_price_symbol", nullable = false)
    private PastPrice pastPrice;

    public PastPrice getPastPrice() {
      return pastPrice;
    }

    public void setPastPrice(PastPrice pastPrice) {
      this.pastPrice = pastPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}