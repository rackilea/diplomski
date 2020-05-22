public static List<Office> rearrange(List<Office> source, String... locations) {
    Map<String, List<Office>> map = new HashMap<>();
    for (Office office : source) {
        List<Office> lst = map.get(office.getLocation());
        if (lst == null) {
            lst = new ArrayList<>();
            map.put(office.getLocation(), lst);
        }
        lst.add(office);
    }
    List<Office> resultList = new ArrayList<>();
    for (String loc : locations) {
        List<Office> partial = map.get(loc);
        if (partial != null) {
            resultList.addAll(partial);
        }
    }
    return resultList;
}