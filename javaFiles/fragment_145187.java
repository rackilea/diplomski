public class Method implements java.io.Serializable{

    /** use serialVersionUID for interoperability */
    private static final long serialVersionUID = 1L;

    String value;

    public Method(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return this.value;
    }
}