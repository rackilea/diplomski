int max = Character.getNumericValue(number.charAt(0));
for (int i = 1; i < number.length(); i++) {
    int compare = Character.getNumericValue(number.charAt(i));
    if (max < compare) {
        max = compare;
    }
}
return max;