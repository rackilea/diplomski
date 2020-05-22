public abstract class ReadWriteListener {
    private int uid;

    public ReadWriteListener(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid; //or just make uid final and public
    }

    public abstract void onEvent(BleDevice.ReadWriteEvent event);
}