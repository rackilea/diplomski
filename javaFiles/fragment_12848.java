class AddInsideClassVar{
    static int a = 3;        // ok this is a declaration for a field (variable)
    static int c;            // ok, this is too
    //c = a + a;        // this is a statement and not a declaration. A field may be 
                      // declared only once
    static int d = a + a;    // this will work since it is part of a declaration.

    public static void main(String args[]){
        System.out.println("a=" + a + ", c=" + c + ", d=" + d);

    }
}