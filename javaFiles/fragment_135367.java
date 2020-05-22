public class TableRow {

    private String agr_name;
    private String text;
    private int entryNr;

    public TableRow(String agr_name, String text, int entryNr) {
        this.agr_name = agr_name;
        this.text = text;
        this.entryNr = entryNr;
    }

    public String getAgr_name() {
        return agr_name;
    }

    public void setAgr_name(String agr_name) {
        this.agr_name = agr_name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getEntryNr() {
        return entryNr;
    }

    public void setEntryNr(int entryNr) {
        this.entryNr = entryNr;
    }

}