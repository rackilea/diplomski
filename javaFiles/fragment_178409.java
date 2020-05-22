public class BallUsingTimer implements ActionListener {

    private MovingBall movingBall;

    public BallUsingTimer(MovingBall mb) {
        movingBall = mb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        movingBall.updateBall();
    }

}