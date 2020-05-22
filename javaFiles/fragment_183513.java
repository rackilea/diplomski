public interface DbValuesEnumIface<ID, T extends Enum<T>> {

   public static
   <ID, T extends Enum<T>&DbValuesEnumIface<ID,T>> T fromId(ID id, Class<T> type) {
        if (id == null) {
            return null;
        }
        for (T en : type.getEnumConstants()) {
            if (en.getId().equals(id)) {
                return en;
            }
        }
        throw new NoSuchElementException();
    }

    ID getId();

    String getDescriptionKey();
}