public class CommandPatternExample {
    public static void main(String[] args) throws Exception {
        CommandEnum.valueOf("A").execute(); // run command "A"
        CommandEnum.valueOf("B").execute(); // run command "B"
        CommandEnum.valueOf("C").execute(); // IllegalArgumentException
    }

    interface Command {
        void execute();
    }

    enum CommandEnum implements Command {
        A {
            @Override
            public void execute() {
                System.out.println("Running command A");
            }
        },
        B {
            @Override
            public void execute() {
                System.out.println("Running command B");
            }
        };
    }
}