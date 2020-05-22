public class SerializedConig {

    protected String field;

    public SerializedConig(String value) {
        try {
            field = this.getClass().getDeclaredField("field");
            field.setAccessible(true);
            field.set(this, value);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

public class ExampleConfig extends SerializedConig {  
    public ExampleConfig(String value) {
        super(value);
    }
}