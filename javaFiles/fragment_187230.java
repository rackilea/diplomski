public class Meta {

    private String uc;
    private String pip;
    private String lot;

    public String getUc() {
        return uc;
    }

    @XmlAttribute
    public void setUc(String uc) {
        this.uc = uc;
    }

    public String getPip() {
        return pip;
    }

    @XmlAttribute
    public void setPip(String pip) {
        this.pip = pip;
    }

    public String getLot() {
        return lot;
    }

    @XmlAttribute
    public void setLot(String lot) {
        this.lot = lot;
    }
}