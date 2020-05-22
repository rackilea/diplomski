public static List<View> getAllChildren(View v, Class<?> myClass) {
    /* ... */
    if (myClass.isInstance(v)) {
        resultList.add(v);
    }
    /* ... */
}