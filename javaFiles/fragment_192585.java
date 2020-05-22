System.out.print("[Code: Gdr1]  Grade 1: %");
Scanner scanner = new Scanner(System.in);
if (scanner.hasNextDouble()) {
    // it's a Double
    Double d = scanner.nextDouble();
    /*
      conditions based on the double
    */
} else if (scanner.hasNext()) {
    // it's not a Double, so it may be "restart"
    String s = scanner.next();
    if ("restart".equalsIgnoreCase(s)) {
        restart01();
    } else {
        System.out.println("("+s+") cannot be resolved in my system...");
        Gdr1();
    }
}
// else we've read everything, we're done