// Extended parameters (naturally you make these names meaningful)
class ExtendedParams extends StandardParams {
    private String thatArg;

    public ExtendedParams(String thisArg, String thatArg) {
        super(thisArg);
        this.thatArg = thatArg;
    }

    public String getThatArg() {
        return this.thatArg;
    }
}

// A subclass requiring extended parameter information
class Sub2 extends Base {
    public Sub2(ExtendedParams args) {
        super(args);
        System.out.println("Sub2 thisArg: " + args.getThisArg());
        System.out.println("Sub2 thatArg: " + args.getThatArg());
    }
}