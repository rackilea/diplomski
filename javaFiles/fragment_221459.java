public interface EnumInf<T extends EnumInf<T>> {
    public int getIndex();
    public T getEnum(int index);
}

public enum ENUM_A implements EnumInf<ENUM_A> {
    ... the rest of your code