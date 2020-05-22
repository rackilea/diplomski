@Override
    public String toString() {
        return getReportHeader() 
                + getReportBase() 
                + getReportSpecifics() 
                + getReportFooter();
    }

    protected String getReportHeader() {
        return String.format("%s: %s",
                             "Commissioned Employee", super.toString());
    }

    protected String getReportBase() {
        return String.format("\n%s %s \n%s:$%,.2f",
                             "Gross Sales", getGrossSales(),
                             "Commission Rate", getCommissionRate());
    }

    protected String getReportSpecifics() {
        return "";
    }

    protected String getReportFooter() {
        return String.format("\n%s $%.2f", "Earnings:", earnings());
    }