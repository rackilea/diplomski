public abstract class Super {

    public static void main(String[] args) {
        Super s = new Sub();
        s.main(); 
    }

    public abstract void run();

    public void main() {
        System.out.println("Calling sub class's implementation of run");
        // The super class does not know the implementation of run
        // but it does know that there must be an implementation to use.
        run();
        System.out.println("Done!");
    }

}

class Sub extends Super {

    @Override
    public void run() {
        System.out.println("sub class implementation of run");
    }

}