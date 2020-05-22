public class DifEasy extends JFrame {
    private ScoreStorage scoreStorage;

    public DifEasy(ScoreStorage scoreStorage) {
        this.scoreStorage = scoreStorage;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (q1a1.isSelected()){
            scoreStorage.setRawscore(scoreStorage.getRawscore()+1);
        }
        this.setVisible(false);
        new DifEasy1(scoreStorage).setVisible(true);
    }