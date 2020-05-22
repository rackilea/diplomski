public static void main(String[] args) {
    String str = "^(C[OC]|E[X]|F[R])[0-9]{4}(/{1})[0-9]{1,8}$";

    System.out.println("CC2007/67".matches(str));
    System.out.println("CO2001/123".matches(str));
    System.out.println("CC2001/123".matches(str));
    System.out.println("EX2001/123".matches(str));
    System.out.println("VR2001/123".matches(str));

}