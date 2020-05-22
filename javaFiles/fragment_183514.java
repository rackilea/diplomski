public interface DbValuesEnumIface<ID, T extends Enum<T>&DbValuesEnumIface<ID,T>> {

    public default T fromId(ID id) {
        if (id == null) {
            return null;
        }
        for (T en : getDeclaringClass().getEnumConstants()) {
            if (en.getId().equals(id)) {
                return en;
            }
        }
        throw new NoSuchElementException();
    }
    Class<T> getDeclaringClass();//no needed to implement it, inherited by java.lang.Enum
    ID getId();
    String getDescriptionKey();
}