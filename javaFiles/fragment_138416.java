import java.lang.reflect.Field;
import java.util.Random;
public class Reflection {

    static final int ITERATIONS = 100;

    static final String[] STRINGS = { "asdf", "qwer", "dfgh", "scvb", "ertyerty" };

    static final Random random = new Random(System.currentTimeMillis());

    static Field fielda;
    static Field fieldb;
    static Field fieldc;
    static Field fieldd;
    static Field fielde;
    static Field fieldf;
    static Field fieldg;
    static Field fieldh;
    static Field fieldi;
    static Field fieldj;
    static Field fieldk;
    static Field fieldl;

    static {
        try {
            fielda = Blah.class.getField("a");
            fieldb = Blah.class.getField("b");
            fieldc = Blah.class.getField("c");
            fieldd = Blah.class.getField("d");
            fielde = Blah.class.getField("e");
            fieldf = Blah.class.getField("f");
            fieldg = Blah.class.getField("g");
            fieldh = Blah.class.getField("h");
            fieldi = Blah.class.getField("i");
            fieldj = Blah.class.getField("j");
            fieldk = Blah.class.getField("k");
            fieldl = Blah.class.getField("l");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; true; i++) {
            System.out.println("i=" + i + ", direct=" + testDirectCallSpeed() + ", reflective=" + testReflectiveCallSpeed());
        }
    }

    static class Blah {

        public String a, b, c, d, e, f;
        public int g, h, i, j, k, l;

        public String toString() {

            StringBuilder sb = new StringBuilder(100);
            sb.append(super.toString());
            sb.append(", a=").append(a);
            sb.append(", b=").append(b);
            sb.append(", c=").append(c);
            sb.append(", d=").append(d);
            sb.append(", e=").append(e);
            sb.append(", f=").append(f);
            sb.append(", g=").append(g);
            sb.append(", h=").append(h);
            sb.append(", i=").append(i);
            sb.append(", j=").append(j);
            sb.append(", k=").append(k);
            sb.append(", l=").append(l);
            return sb.toString();
        }
    }

    public static long testDirectCallSpeed() {

        System.gc();
        Blah[] blahs = new Blah[ITERATIONS];
        long begin = System.currentTimeMillis();
        Blah blah;
        for (int i = 0; i < ITERATIONS; i++) {
            blah = new Blah();
            blah.a = getString();
            blah.b = getString();
            blah.c = getString();
            blah.d = getString();
            blah.e = getString();
            blah.f = getString();
            blah.g = getInt();
            blah.h = getInt();
            blah.i = getInt();
            blah.j = getInt();
            blah.k = getInt();
            blah.l = getInt();
            blahs[i] = blah;
        }
        long exectionTime = System.currentTimeMillis() - begin;
        printRandomBlah(blahs);
        return exectionTime;
    }

    public static long testReflectiveCallSpeed() throws Exception {

        System.gc();
        Blah[] blahs = new Blah[ITERATIONS];
        long begin = System.currentTimeMillis();
        Blah blah;
        for (int i = 0; i < ITERATIONS; i++) {
            blah = new Blah();
            fielda.set(blah, getString());
            fieldb.set(blah, getString());
            fieldc.set(blah, getString());
            fieldd.set(blah, getString());
            fielde.set(blah, getString());
            fieldf.set(blah, getString());
            fieldg.set(blah, getInt());
            fieldh.set(blah, getInt());
            fieldi.set(blah, getInt());
            fieldj.set(blah, getInt());
            fieldk.set(blah, getInt());
            fieldl.set(blah, getInt());
            blahs[i] = blah;
        }
        long executionTime = System.currentTimeMillis() - begin;
        printRandomBlah(blahs);
        return executionTime;

    }

    public static void printRandomBlah(Blah[] blahs) {

        // System.out.println(blahs[random.nextInt(blahs.length)]);
    }

    public static int getInt() {

        return random.nextInt();
    }

    public static String getString() {

        return STRINGS[random.nextInt(STRINGS.length)];
    }

}