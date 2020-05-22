public static String pwdgen(String s) {
    String[] Splitted = s.split(" ");
    int count = s.split(" ").length;
    int i = 0;

    String pass = "";
    boolean addFirstLetter = true;
    for(i = 0; i < count; i = i + 1) {
        pass += (addFirstLetter) ? Splitted[i].substring(0, 1) : Splitted[i].substring(Splitted[i].length() - 1);
        addFirstLetter = !addFirstLetter;
    }

    return count + pass;
}

public static void main(String[] args) {
    String pwd = pwdgen("Dies ist nur ein doofes Beispiel");
    System.out.println(pwd); // => "6Dtnndl"
    System.out.println(pwdgen("a b c")); // => 3abc
}