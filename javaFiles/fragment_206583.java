public class Rate {
    private String rates;
    private String comments;

    public Rate(String rates, String comments) {
        this.rates = rates;
        this.comments = comments;
    }
    public Rate(){}

    public String getRates() {
        if (rates == null) return "0.0";
        else return rates;
    }

    public void setRates(String rates) {
        this.rates = rates;
    }

    public String getComments() {
        if (comments == null) return ""; // Return empty string
        else return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}