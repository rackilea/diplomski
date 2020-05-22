public static boolean contains(List<String>list1, List<String>list2) {
    for (String str : list1) {
        if (list2.contains(str)) {
            return true;
        }
    }
    return false;
}