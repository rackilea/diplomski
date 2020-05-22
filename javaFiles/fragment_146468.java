for (int i = 0; i < s.length(); i++) {
    for (int j = 0; j < s.length()-i; j++) {
        System.out.print(s.charAt(j));
    }
    for (int j = s.length()-i; j < s.length(); j++) {
        System.out.print(" ");
    }
    for (int j = 0; j < i; j++) {
        System.out.print(" ");
    }
    for (int j = i; j < s.length(); j++) {
        System.out.print(s.charAt(j));

    }
    System.out.println("");
}