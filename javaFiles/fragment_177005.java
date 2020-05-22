public static void main(String args[]) {
    String a[] = new String[] { "+90030", "3434", "+403403", "+477777777" };

    String regEx = "\\+\\d{9}";
    Pattern pattern = Pattern.compile(regEx);

    for (int i = 0; i < a.length; i++) {
        boolean matches = pattern.matcher(a[i]).matches();
        if (matches)
            System.out.println("Phone number is valid" + a[i]);
        else
            System.out.println("Phone number is invalid" + a[i]);
    }
}