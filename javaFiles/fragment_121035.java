Collections.sort(list, new Comparator<String>() {
    public void compare(String one, String two) {
         return getNumber(one) - getNumber(two);
    }
    private int getNumber(String str) {
        return Integer.parseInt(one.split(" ")[0]);
    }
}