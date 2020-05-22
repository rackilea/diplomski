@Data
@NoArgsConstructor
@AllArgsConstructor

public class CurrencyModel {

    @JsonProperty("table")
    private String table;

    @JsonProperty("no")
    private String no;

    @JsonProperty("effectiveDate")
    private String effectiveDate;

    @JsonProperty("rates")
    private ArrayList<CurrenciesRates> rates;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class CurrenciesRates {
        @JsonProperty("currency")
        private String currency;

        @JsonProperty("code")
        private String code;

        @JsonProperty("mid")
        private String mid;
    }
}