try {
    int zero = 0;
    int y = 2/zero;

    Object s = null;
    try {            
        System.out.println(s.toString());
    } catch(NullPointerException e) {
        System.out.println("'s' was null, creating a new 's'");
        s = new Object();
    }
    System.out.println(s.toString());

} catch(ArithmeticException e) {
    System.out.println(e);
}