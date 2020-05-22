public class CompositeIOSubsystem implements IOSubsystem {

    List<IOSubsystem> subsystems = new ArrayList<IOSubsystem>();

    public void showMessage(String msg) {
        for (IOSubsystem subsystem: subsystems)
            subsystem.showMessage(msg);
    }

    public void add(IOSubsystem subsystem) {
        subsystems.add(subsystem);
    }
}