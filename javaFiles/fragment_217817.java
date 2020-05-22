public static Collection<Object[]> browserList() {
    Object[] firefox = { "firefox" };
    Object[] chrome = { "chrome" };
    Object[] ie = { "ie" };
    ArrayList<Object[]> list = new ArrayList<Object[]>(3);
    list.add(firefox);
    list.add(chrome);
    list.add(ie);
    return list;
}