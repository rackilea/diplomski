public class ChangeEvent extends ComponentEvent<AbstractCallableComponent> {

    public ChangeEvent(AbstractCallableComponent source, boolean fromClient) {
        super(source, fromClient);
    }
}