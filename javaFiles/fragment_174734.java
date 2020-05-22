String toString(Object o) {
   return ((Enum) o).name();
}

<T extends Enum<T>> Object fromString(Class<T> enumType, String o) {
   return Enum.valueOf(enumType, o);
}