static boolean distinctElements(String[] array) {
    Set<String> set = new HashSet<>();
    for (String str : array) {
        if (!set.add(str)) {
            return false;
        }
    }
    return true;
}