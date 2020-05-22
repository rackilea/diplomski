public class ScreenController extends JPanel {

    private static final long serialVersionUID = 1L;
//-------------VARIABLES---------------//
    MenuScreen ms = new MenuScreen();
    GameScreen gs = new GameScreen();
    CardLayout sceneChange;

//-------------CONSTRUCTOR-------------//
    public ScreenController() {

        sceneChange = new CardLayout();

        this.setLayout(sceneChange);
        add(ms, "menuScreen");
        add(gs, "gameScreen");

        sceneChange.show(this, "menuScreen");

        ms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equalsIgnoreCase("startgame")) {
                    sceneChange.show(ScreenController.this, "gameScreen");
                }
            }
        });
    }

}//END OF CLASS startingScreen