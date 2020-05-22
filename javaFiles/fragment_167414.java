class QuoteRequest {
    private List<Accident> accidents = new ArrayList<>();  // I prefer List or Set

    public void setAccidents(List<Accident> accidents) {
        this.accidents.clear();
        if (accidents != null) {
            // intentionally keeping another list, to be defensive and not
            // affected by subsequent change in the caller's list
            this.accidents = this.accidents.addAll(accidents);
            for (Accident accident:accidents) {
                accident.setQuoteRequest(this);
            }
        }
    }
}

class Accident {
    private QuoteRequest quoteRequest;
    public setQuoteRequest(QuoteRequest quoteRequest) {
        // there will be something more...
        this.quoteRequest = quoteRequest;
    }
}