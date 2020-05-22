public static boolean emptyOrAllNulls(Collection<?> c) {
    if (c != null)
        for (Object o : c)
            if(o != null)
                return false;

    return true;
}