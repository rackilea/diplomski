public static void main(String args[]) {
    int src = Integer.parseInt(args[0]);
    IAbstractFactory factory = null;
    if (src == 1)
        factory = new AFactory();
    else if (src == 2)
        factory = new BFactory();
    IAbstract obj = factory.create();
    // ....
}