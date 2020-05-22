public static int getCap(ArrayList<?> list) throws Exception {
    Field f = list.getClass().getDeclaredField("elementData");
    f.setAccessible(true);
    Object[] o = (Object[]) f.get(list);
    return o.length;
}