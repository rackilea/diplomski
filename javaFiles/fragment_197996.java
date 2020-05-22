public interface RobotVisitor {
public VisitorData visitHead(Head p, VisitorData arg);
public VisitorData visitNeck(Neck p, VisitorData arg);
public VisitorData visitShoulder(Shoulder p, VisitorData arg);
public VisitorData visitArm(Arm p, VisitorData arg);
....
// A lot of methods.
}