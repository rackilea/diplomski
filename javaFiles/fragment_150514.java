public class Magic {

    private Integer id;
    private String name;


    public Magic() {
    }


    public Magic(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Data [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name : "") + "]";
    }

}