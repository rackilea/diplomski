import java.lang.reflect.*;

public class GetTheStatic {
    public static final void main(String[] args) {
        String className;
        String fieldName;
        Class cls;
        Field fld;
        String value;

        if (args.length != 2) {
            System.out.println("Need [classname] [fieldName]");
            System.exit(-1);
        }

        try {
            className = args[0];
            fieldName = args[1];

            cls = Class.forName(className);
            fld = cls.getField(fieldName);
            value = (String)fld.get(cls);
            System.out.println("Field value is " + value);
            System.exit(0);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            System.exit(-1);
        }
    }
}