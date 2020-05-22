public class BatchResponse {

    @SerializedName("quote")
    @Expose
    private Quote quote;
    @SerializedName("stats")
    @Expose
    private Stats stats;

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote_ quote) {
        this.quote = quote;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

}