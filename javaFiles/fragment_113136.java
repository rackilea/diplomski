public class TotalBean{

    private String total = "";

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public String fetchTotal() {
        this.total = rs.getString("Earning_Amount");
        return total;
    }

    public void closeDialog() {
        this.total = "";
    }
}