public class Something extends RealmObject {
    public static final String TYPE_A = "a";
    public static final String TYPE_B = "b";
    public static final String TYPE_C = "c";
    public static final String TYPE_D = "d";

    private String a;
    private String b;
    private String c;
    private String d;

    @Index
    private String discriminator;

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public void setA(String a) {
        this.a = a;
        this.b = null;
        this.c = null;
        this.d = null;
        this.discriminator = TYPE_A;
    }

    public void setB(String b) {
        this.a = null;
        this.b = b;
        this.c = null;
        this.d = null;
        this.discriminator = TYPE_B;
    }

    public void setC(String c) {
        this.a = null;
        this.b = null;
        this.c = c;
        this.d = null;
        this.discriminator = TYPE_C;
    }

    public void setD(String d) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = d;
        this.discriminator = TYPE_D;
    }
}