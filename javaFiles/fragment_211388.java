public static boolean isListContainMethod(List<String> arraylist) {
    for (String str : arraylist) {
        if (!str.toLowerCase().contains("method")) {
            return false;
        }
    }
    return true;
}