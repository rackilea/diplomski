import org.apache.commons.lang3.EnumUtils;

public class EnumApp {

    enum Type {
        INT,
        STRING
    }

    public static void main(String[] args) {
        System.out.println(EnumUtils.getEnum(Type.class, "INT"));
        System.out.println(EnumUtils.getEnum(Type.class, "STRING"));
        System.out.println(EnumUtils.getEnum(Type.class, "STRING1"));
    }
}