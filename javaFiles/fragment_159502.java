// The standard parameters needed
class StandardParams {
    private String thisArg;

    public StandardParams(String thisArg) {
        this.thisArg = thisArg;
    }

    public String getThisArg() {
        return this.thisArg;
    }
}

// The base class
class Base {
    public Base(StandardParams args) {
        System.out.println("Base: " + args.getThisArg());
    }
}

// A standard subclass
class Sub1 extends Base {
    public Sub1(StandardParams args) {
        super(args);
        System.out.println("Sub1 thisArg: " + args.getThisArg());
    }
}