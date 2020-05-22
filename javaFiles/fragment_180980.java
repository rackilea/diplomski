public class Something extends RealmObject {
    public static final String TYPE_A = "a";
    public static final String TYPE_B = "b";
    public static final String TYPE_C = "c";
    public static final String TYPE_D = "d";

    @Index
    private String discriminator;

    private String value;

    // getters, setters

    public void setA(String a) {
        this.value = a;
        this.discriminator = TYPE_A;
    }

    public void setB(String b) {
        this.value = b;
        this.discriminator = TYPE_B;
    }

    public void setC(String c) {
        this.value = c;
        this.discriminator = TYPE_C;
    }

    public void setD(String d) {
        this.value = d;
        this.discriminator = TYPE_D;
    }
}