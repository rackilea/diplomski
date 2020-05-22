public interface Greeter {
    String greet();
}

public enum EnumGreeterImpl implements Greeter {
    GREETER1 {
        @Override
        public String greet() {
            return "Hello World!";
        }
    },
    GREETER2 {
        @Override
        public String greet() {
            return "Foo bar";
        }
    },
}

private void run() {
    Greeter foo = EnumGreeterImpl.GREETER1;
    System.out.println(foo.greet());
}