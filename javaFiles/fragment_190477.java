public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner in = new Scanner(System.in);
    boolean sw1 = false;
    String st1 = in.next();
    for (int i = 0; i < st1.length(); i++) {
        if (st1.charAt(i) >= 48 && st1.charAt(i) <= 57) sw1 = true;
    }
    System.out.println(sw1);
}