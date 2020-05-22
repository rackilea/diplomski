class ApiResponse {
    private Map<String, Info> page = new HashMap<>();
    private Date timestamp;

    public Map<String, Info> getPage() {
        return page;
    }

    @JsonAnySetter
    public void setPage(String name, Info value) {
        page.put(name, value);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

class Info {
    private String display_URL;
    private String display_name;
    private Rates rates;
    private String source;
    private Double volume_btc;
    private Double volume_percent;

    public String getDisplay_URL() {
        return this.display_URL;
    }

    public void setDisplay_URL(String display_URL) {
        this.display_URL = display_URL;
    }

    public String getDisplay_name() {
        return this.display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public Rates getRates() {
        return this.rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Double getVolume_btc() {
        return this.volume_btc;
    }

    public void setVolume_btc(Double volume_btc) {
        this.volume_btc = volume_btc;
    }

    public Double getVolume_percent() {
        return this.volume_percent;
    }

    public void setVolume_percent(Double volume_percent) {
        this.volume_percent = volume_percent;
    }
}

class Rates {
    private Double ask;
    private Double bid;
    private Double last;

    public Number getAsk() {
        return this.ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getBid() {
        return this.bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getLast() {
        return this.last;
    }

    public void setLast(Double last) {
        this.last = last;
    }
}