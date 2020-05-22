class ForIt {
    private static final FU fu = new FU();

    ForIt() {
        fu.add(this);
    }

    static int sum() {
        return fu.sum();
    } 
}

public static void main(String... args) {
    new ForIt();
    new ForIt();
    System.out.println(ForIt.sum());
}