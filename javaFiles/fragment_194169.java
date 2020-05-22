public class ActionPerformer implements ActionListener {
    private movingGame game;

    public ActionPerformer(movingGame mg) {
        this.game = mg;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.game.timeToDraw();
    }
}