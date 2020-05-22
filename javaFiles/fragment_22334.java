public class FireworkModel {

    private int angle;
    private int velocity;
    private int time;

    private List<ChangeListener> changeListeners;

    public FireworkModel() {
        changeListeners = new ArrayList<>();
    }

    public void addChangeListener(ChangeListener listener) {
        changeListeners.add(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        changeListeners.remove(listener);
    }

    protected void fireStateChanged() {
        ChangeEvent evt = new ChangeEvent(this);
        for (ChangeListener listener : changeListeners) {
            listener.stateChanged(evt);
        }
    }

    public void setAngle(int angle) {
        this.angle = angle;
        fireStateChanged();
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
        fireStateChanged();
    }

    public void setTime(int time) {
        this.time = time;
        fireStateChanged();
    }

    public int getAngle() {
        return angle;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getTime() {
        return time;
    }

    public int findx() {
        return Fire_WorkMath.calculatex(getVelocity(), getTime(), getAngle());
    }

    public int findy() {
        return Fire_WorkMath.calculatey(getVelocity(), getTime(), getAngle());
    }

}