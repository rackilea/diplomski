//----------------- Event --------------
public class DataChangeEvent {
    private String message;

    public DataChangeEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}

//----------------- Listener --------------
public interface DataChangeListenter {
    public void dataChangeEvent(DataChangeEvent event);
}

//----------------- Event Handler that fires the dataChange events --------------
// This class needs to be static since you need to register all your classes that want to be notified of data change events
public class DataChangedHandler {
    private static List<DataChangeListenter> listeners = new ArrayList<DataChangeListenter>();

    public static void registerDataChangeListener(DataChangeListenter listener) {
        listeners.add(listener);
    }

    public static void fireDataChange(DataChangeEvent dataChangeEvent) {
        for(DataChangeListenter listenter : listeners) {
            listenter.dataChangeEvent(dataChangeEvent);
        }
    }
}

//----------------- Example class that implements the listener and registers itself for events --------------
public class ProcessMessage implements DataChangeListenter {

    public ProcessMessage() {
        DataChangedHandler.registerDataChangeListener(this);
    }

    public void dataChangeEvent(DataChangeEvent event) {
        //Depending on your protocal, I use Antlr to parse my message
        System.out.println(event.getMessage());
    }


}

//---------------- Netty Handler -----------
public class TelnetClientHandler extends SimpleChannelHandler {

    private static final Logger logger = Logger.getLogger(TelnetClientHandler.class.getName());

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        String message = (String) e.getMessage();
        DataChangedHandler.fireDataChange(message);
    }
}