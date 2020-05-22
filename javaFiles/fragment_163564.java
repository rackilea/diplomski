public static String base64StringToId(String base64String) {
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
    long id = 0L;
    for (int i = 0; i < base64String.length(); i++) {
        char c = base64String.charAt(i);
        int i1 = alphabet.indexOf(c);
        id = (id * 64) + i1;
        //id += i1 * Math.pow(64, base64String.length() - 1 - i);
        //converted[string.length() - i - 1] = i1;
    }
    System.out.println(String.format("input is %s, output is %s", base64String, String.valueOf(id)));
    return String.valueOf(id);
}