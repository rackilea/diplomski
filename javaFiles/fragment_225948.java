public static <T> List<T> checkElements(List<?> list, Class<T> elementClass) {
    for(Object e : list) {
        elementClass.cast(e); // throw CCE on wrong element
    }
    @SuppressWarnings("unchecked")
    List<T> result = (List<T>)list;
    return result;
}