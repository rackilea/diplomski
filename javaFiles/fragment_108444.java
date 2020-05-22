public class MyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Locale locale;
    private String foo;

    public MyBean() {
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

}