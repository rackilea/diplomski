public class Report {

    private String total;

    private Map monthly;

    public Report () {
        total = "10";
        monthly = new HashMap<>();
        monthly.put("MAR", 5);
        monthly.put("JUN", 5);
    }

    public String getTotal() {
        return total;
    }

    @JsonAnyGetter
    public Map getMonthly() {
        return monthly;
    }

}