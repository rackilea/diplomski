public class ACAdata implements Comparable<ACAdata> {

    // variables declared for each column of data in the line
    String state = " "; // State abbreviation
    String org = " "; // Organizer of the ACA marketplace, either FFM for federally facilitated marketplace or SBM for state based marketplace.
    double numEll = 0; // Number of citizens in the state eligible for ACA coverage
    double numEn = 0; // Number of citizens who enrolled in an ACA plan
    double percentage = 0;

    public ACAdata(String state, String org, double numEll, double numEn, double percentage) {
        state = state;
        org = org;
        numEll = numEll;
        numEn = numEn;
        percentage = percentage;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrg() {
        return this.org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public double getNumEll() {
        return this.numEll;
    }

    public void setNumEll(double numEll) {
        this.numEll = numEll;
    }

    public double getNumEn(double numEn) {
        return this.numEn;
    }

    public double getPercentage() {
        return this.percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public int compareTo(ACAdata o) {
        if (percentage > o.percentage) {
            return -1;
        }
        if (percentage < o.percentage) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Put the info you want here!";
    }

}