// (copy from PlaceChangeEvent)
public class MessageEvent extends GwtEvent<MessageEvent.Handler> 

 public interface Handler extends EventHandler {
   void onMessage(MessageEvent event);
  }
  //... rest like PlaceChangeEvent, but with PlaceChange replaced with Message
  // and instead of Place or use String message or a more advanced Message you create,
  // which contains the message data.
}