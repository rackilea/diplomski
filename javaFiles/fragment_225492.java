public abstract class AbstractSender implements Sendable {
    public abstract void send();

    public void sendMe() {
        send(this.toString());
    }
}