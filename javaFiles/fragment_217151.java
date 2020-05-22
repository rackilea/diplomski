public class Division {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("alsoKnownAs")
    @Expose
    private List<String> alsoKnownAs = new ArrayList<>();
    @SerializedName("officeIndices")
    @Expose
    private List<Integer> officeIndices = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public List<Integer> getOfficeIndices() {
        return officeIndices;
    }

    public void setOfficeIndices(List<Integer> officeIndices) {
        this.officeIndices = officeIndices;
    }
}