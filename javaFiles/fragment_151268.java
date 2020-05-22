public class MyRobot extends AdvancedRobot {
    private RobotStatus robotStatus;

    (...)

    public void onStatus(StatusEvent e) {
        this.robotStatus = e.getStatus());
    }    

    public void onScannedRobot(ScannedRobotEvent e) {
        double angleToEnemy = e.getBearing();

        // Calculate the angle to the scanned robot
        double angle = Math.toRadians((robotStatus.getHeading() + angleToEnemy % 360);

        // Calculate the coordinates of the robot
        double enemyX = (robotStatus.getX() + Math.sin(angle) * e.getDistance());
        double enemyY = (robotStatus.getY() + Math.cos(angle) * e.getDistance());
    }

    (...)
}