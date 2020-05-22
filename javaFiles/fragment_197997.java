public class Arm extends BodyPart {
    // Some fields, getters and setters...

    public VisitorData accept(RobotVisitor visitor, VisitorData arg) {
        return visitor.visitArm(this, arg);
    }
}