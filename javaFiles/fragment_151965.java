public abstract class JobListener {

@ServiceActivator
public void receiveMessage(Message<String> message){
    Helper helper = createHelper();
    helper.processMassage(message);
    }

protected abstract Helper createHelper();
}