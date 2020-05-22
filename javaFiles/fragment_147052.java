public class IpTask extends Task<Void> {

    private final Text textIp;

    public IpTask(Text textIp) {
        if (textIp == null) {
            throw new IllegalArgumentException();
        }
        this.textIp = textIp;
    }

    ...

    @Override
    protected void succeeded() {
        System.out.println("Updated");
        textIp.setText("JUST TO SEE IF THE TEXT GETS SET");
    }
}