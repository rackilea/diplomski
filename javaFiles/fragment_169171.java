public class Data {
            private String current_day;
    private double open_val;
    private double high_val;
    private double low_val;
    private double close_val;

    public Data(String current_day, double open_val, double high_val,
            double low_val, double close_val) {
        this.current_day = current_day;
        this.open_val = open_val;
        this.high_val = high_val;
        this.low_val = low_val;
        this.close_val = close_val;
    }

    public String getCurrent_day() {
        return current_day;
    }

    public void setCurrent_day(String current_day) {
        this.current_day = current_day;
    }

    public double getOpen_val() {
        return open_val;
    }

    public void setOpen_val(double open_val) {
        this.open_val = open_val;
    }

    public double getHigh_val() {
        return high_val;
    }

    public void setHigh_val(double high_val) {
        this.high_val = high_val;
    }

    public double getLow_day() {
        return low_val;
    }

    public void setLow_day(double low_day) {
        this.low_val = low_day;
    }

    public double getClose_day() {
        return close_val;
    }

    public void setClose_day(double close_day) {
        this.close_val = close_day;
    }

    }