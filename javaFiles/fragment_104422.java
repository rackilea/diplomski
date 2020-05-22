public int h = 44;
public int getH() { // Declaration, not invocation.
    System.out.println(" test " + h);
    return h;
}
public static void main( String[] args) {
    Beta b = new Beta(); // Instantiation. Does not call getH.
    System.out.println( b.getH()); // <-- Now, getH is called on instance b.
}