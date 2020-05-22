public interface Robot {

}

// Implementation of this is to be injected by the IoC in the Robot instances
public interface Brain {
    String think();
}

public class RobotImpl implements Robot {

    private final String name_;
    private final Brain brain_;

    @Inject
    public RobotImpl(String name, Brain brain) {
        name_ = name;
        brain_ = brain;
    }

    public String toString() {
        return "RobotImpl [name_=" + name_ + "] thinks about " + brain_.think();
    }
}

public class RobotBrain implements Brain {
    public String think() {
        return "an idea";
    }
}