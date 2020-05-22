public class PageField<E extends Enum<E>>{

    private Class<E> enumClass;

    public PageField(Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    public E getSelectedValue() {
        String value = getValueFromElement(this.id);
        return Enum.valueOf(enumClass, value);
    }

}