Collections.sort(myList, new Comparator<String, String>() {
    public int compare(String left, String right) {
        String leftLast = String.split("\\s")[1];
        String rightLast = String.split("\\s")[1];
        return leftLast.compareTo(rightLast);
    }
}