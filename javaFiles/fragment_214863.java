public class Container {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contains")
    @Expose
    private List<Container> contains;

    public Container(String name) {
        this.name = name;
        contains = new ArrayList<Container>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Container c) {
        this.contains.add(c);
    }

    public void setContainerList(List<Container> contains) {
        this.contains = contains;
    }

    public String getName() {
        return name;
    }

    public List<Container> getContainerList() {
        return this.contains;
    }
}