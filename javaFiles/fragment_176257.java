static Character[] sort(String s) {
    Character[] temp = new Character[s.length()];
    for (int i = 0; i < temp.length; i++) {
        temp[i] = s.charAt(i);
    }
    Arrays.sort(temp);
    return temp;
}