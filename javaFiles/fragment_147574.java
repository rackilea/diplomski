class MainFrame2 {

    private MainFrame2() {
        super("An awesome piece of software");
        // etc.. no modules added here
    }

    public static MainFrame2 newInstance() {
        MainFrame2 result = new MainFrame2();

        new PingPong(api, result);
        // alternatively something like:
        // result.addModuleToLeftPanel("Teste", new PingPong(api))

        // add more here

        result.updateTheLayoutBecauseThereAreNewModules();
        return result;
    }
}

class User {
    public static void main(String[] args) {
        MainFrame2 frame = MainFrame2.newInstance();
            // instead of: new MainFrame2();
    }
}