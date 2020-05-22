public static final void main(String[] args) {
    try (
        InnerMost im = new InnerMost();
        Middle m = new Middle(im);
        OuterMost om = new OuterMost(m)
        ) {
        System.out.println("In try block");
    }
    catch (Exception e) {
        System.out.println("In catch block");
    }
    finally {
        System.out.println("In finally block");
    }
    System.out.println("At end of main");
}