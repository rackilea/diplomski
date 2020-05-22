package tests;
import java.lang.reflect.Constructor;
public class Construct {
    static interface CRC { }
    static class CRC8 implements CRC {
        public CRC8(int p) { }
    }
    static class CRC16 implements CRC {
        public CRC16(int p) { }
    }
    static class CRC32 implements CRC {
        public CRC32(int p) { }
    }
    public static CRC getAlg(String s, int polynomial) {
        try {
            Class<?> clazz = Class.forName("tests.Construct$" + s.toUpperCase());
            Constructor<?> c = clazz.getConstructor(Integer.TYPE);
            return CRC.class.cast(c.newInstance(polynomial));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new AssertionError("Unknown algorithm: " +s);
    }
    public static void main(String[] args) throws Exception {
        System.out.println(getAlg("crc8", 0));
        System.out.println(getAlg("crc16", 0));
        System.out.println(getAlg("crc32", 0));
        System.out.println(getAlg("crc48", 0));
    }
}