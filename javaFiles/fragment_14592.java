public class MenuPane {

    public MenuPane() {

        LogPane logPane = new LogPane();
        ButtonPane buttonPane = new ButtonPane();

        buttonPane.setMessageHandler(logPane::push);

        // ...
    }

    // ...
}