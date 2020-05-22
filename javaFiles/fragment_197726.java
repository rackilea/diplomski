public static void main(String[] args) {

    StringBuilder s = new StringBuilder("4857035");
    char aux;

    for (int i = 0; i < s.length() - 1; i++) {
        for (int j = i + 1; j < s.length(); j++) {
            if (s.charAt(i) > (s.charAt(j))) {
                aux = s.charAt(i);
                s.setCharAt(i, s.charAt(j));
                s.setCharAt(j, aux);
            }
        }
    }
    //output 0345578

    while (s.charAt(0) == '0') {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                aux = s.charAt(0);
                s.setCharAt(0, s.charAt(i));
                s.setCharAt(i, aux);
                break;
            }
        }
    }
    //output 3045578
}