public class B implements Letter {
    @XmlValue
    String b;

    public B() {}

    public B(final String value) {
        this.b = value;
    }
}