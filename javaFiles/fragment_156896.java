import java.util.function.BiConsumer;

public class MyObj {
    public static enum Field {
        FIRST_NAME(MyObj::setFirstName),
        LAST_NAME(MyObj::setLastName);

        Field(BiConsumer<MyObj, String> setter) {
            this.setter = setter;
        }

        final BiConsumer<MyObj, String> setter;
    }

    public void set(Field field, String value) {
        field.setter.accept(this, value);
    }

    public void setFirstName(String s) {...}
    public void setLastName(String s) {...}
}