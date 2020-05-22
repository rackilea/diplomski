// ISegment.java
public interface ISegment {
    Boolean validate();
}

// Uno.java
public class Uno implements ISegment {
    public Boolean validate() {
        System.out.print("UNO!!");
        return true;
    }
}

// SegmentFactory.java
public final class SegmentFactory {
    public static enum Supported {
        UNO("uno", Uno.class), /* ... */, HAV("hav", Hav.class);

        private final Class<?> clazz;
        private final String name;

        private Supported(final String name, final Class<?> clazz) {
            this.name = name;
            this.clazz = clazz;
        }

        public Class<?> getClazz() {
            return clazz;
        }

        public static Supported for(final String name) {
            for (final Supported s : values()) {
                if (s.name.equals(name) {
                    return s;
                }
            }
            return null; // a default one
        }
    }

    public static ISegment create(final Supported supp) {
        if (supp == null) {
            return null;
        }
        return supp.getClazz.newInstance();
    }

    private SegmentFactory() {
        // avoid instantiation
    }
}