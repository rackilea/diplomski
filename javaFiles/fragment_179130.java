@Entity
@Table(name = "past_price")
public class PastPrice {

    @Id
    private String symbol;
    @OneToMany(mappedBy = "pastPrice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Price> prices = null;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }

}