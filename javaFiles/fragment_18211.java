@XStreamAlias("mylistofitems")
public class Container {
    public List<Field> fields;

    public void addField(String name, int x, int y, String desc) {
        if (fields == null) fields = new ArrayList<Field>();
        fields.add(new Field(name, x,y, desc));

    }
}

@XStreamAlias("field")
public class Field {
    public Field() {}
    public Field(String name, int x, int y, String desc) {
        this.name = name;
        cordX = x;
        cordY = y;
        value = desc;
    }
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private int cordX;
    @XStreamAsAttribute
    private int cordY;
    @XStreamAsAttribute
    private String value;
}