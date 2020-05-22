import java.util.Observable;

public class ModeObject extends Observable{
    public enum Mode {
        IDLE, NEW, VIEW, EDIT
    }

    private Mode mode;

    public ModeObject() {
        mode = Mode.IDLE;
    }

    public void SetNew() {
        mode = Mode.NEW;
        notifyObservers();
    }

    public void SetIdle() {
        mode = Mode.IDLE;
        notifyObservers();
    }

    public void SetView() {
        mode = Mode.VIEW;
        notifyObservers();
    }

    public void SetEdit() {
        mode = Mode.EDIT;
        notifyObservers();
    }

    public Mode GetMode() {
        return mode;
    }
}