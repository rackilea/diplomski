public static <T> boolean areAllUnique(List<T> list){
    Set<T> set = new HashSet<>();

    for (T t: list){
        if (!set.add(t))
            return false;
    }

    return true;
}