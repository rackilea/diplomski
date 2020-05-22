public class MyAction extends AbstractAction {

    String name;

    MainScreen mainScreen;

    public MyAction(String name, Icon icon, MainScreen s) {
        super(name, icon);
        this.name = name;
        this.mainScreen = s;
    }

    public MyAction(String name, Icon icon,
            Integer mnemonic, KeyStroke accelorator,) {
        super(name, icon);
        putValue(Action.MNEMONIC_KEY, mnemonic);
        putValue(Action.ACCELERATOR_KEY, accelorator);
        this.name = name;
        this.mainScreen = s;
    }

    public void actionPerformed(ActionEvent e) {
        switch (name) {
            case "New Project":
                mainScreen.showNewProDialog();
                break;
            case "New Java File":
                mainScreen.showNewFileDialog();
                break;
            case "Open":
                showOpenProDialog();
                break;
            case "Save":
                System.out.println("Action event of save button.");
                break;
            case "Exit":
                System.out.println("Action event of exit button.");
                System.exit(0);
                break;
            case "Undo":
                System.out.println("Action event of Undo button.");
                break;
            case "Redo":
                System.out.println("Action event of Redo button.");
                break;
            case "Cut":
                System.out.println("Action event of Cut button.");
                break;
            case "Copy":
                System.out.println("Action event of Copy button.");
                break;
            case "Paste":
                System.out.println("Action event of Paste button.");
                break;
            case "Find":
                System.out.println("Action event of Find button.");