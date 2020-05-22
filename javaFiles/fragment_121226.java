public static <A, B extends List<C>, C> B convertList(
    List<A> list, Class<B> targetListClass, Class<C> targetClass) 
    throws Exception {

    B targetList = targetListClass.newInstance();

    for (A object : list) {
        targetList.add(convert(object, targetClass));
    }

    return targetList;
}