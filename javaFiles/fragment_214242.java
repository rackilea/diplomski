public class Item {
    private String name;
    private String gramm;
    //you can also add different variables

    public Item(String name, String gramm) {
        this.name = name;
        this.gramm = gramm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGramm() {
        return gramm;
    }

    public void setGramm(String gramm) {
        this.gramm = gramm;
    }
}