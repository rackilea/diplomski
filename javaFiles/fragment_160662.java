Arrays.sort(yourArray, new Comparator<String>() {
    @Override
    public int compare(String string1, String string2) {
        int number1 = Integer.decode(string1.substring(0, string1.indexOf(" "))); // This assumes that there is always a space after the number
        int number2 = Integer.decode(string2.substring(0, string2.indexOf(" ")));
        return Integer.compare(number1, number2);
    }
});