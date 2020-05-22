public static String caseChanger(String s, int ind) {

    char[] charArr = s.toCharArray();

    if (!(Character.isUpperCase(s.charAt(ind)))) {
        charArr[ind] = Character.toUpperCase(s.charAt(ind));
    } else {
        charArr[ind] = Character.toLowerCase(s.charAt(ind));
    }
    return String.valueOf(charArr);
}