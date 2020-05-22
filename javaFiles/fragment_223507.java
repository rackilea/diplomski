public class Seller {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sco")
    @Expose
    private Integer sco;
    @SerializedName("perc")
    @Expose
    private Double perc;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("brand")
    @Expose
    private Boolean brand;
    @SerializedName("prog")
    @Expose
    private String prog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSco() {
        return sco;
    }

    public void setSco(Integer sco) {
        this.sco = sco;
    }

    public Double getPerc() {
        return perc;
    }

    public void setPerc(Double perc) {
        this.perc = perc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getBrand() {
        return brand;
    }

    public void setBrand(Boolean brand) {
        this.brand = brand;
    }

    public String getProg() {
        return prog;
    }

    public void setProg(String prog) {
        this.prog = prog;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}