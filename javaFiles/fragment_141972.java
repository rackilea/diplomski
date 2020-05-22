public class NotificationButtonIntentService extends IntentService
{

   public static final String TAG = "NotificationButtonIntentService";

   public static final String Action_Play = "play";
   public static final String Action_Pause = "pause";
   public static final String Action_Previous = "previous";
   public static final String Action_Next = "next";
   public static final String Action_Close = "close";

   public NotificationButtonIntentService() 
   {
      super("");
   }

   public NotificationButtonIntentService(String name)
   {
      super(name);

   }

   @Override
   protected void onHandleIntent(Intent intent)
   {
      String action = intent.getAction();
      String realAction = intent.getAction();

      if (realAction != null) 
      {
          if (realAction.equals(Action_Play)) 
          {
             EventBus.getDefault().post(new PlayControlEvent(PlayControlEvent.PlayAction.PLAY));    
          } 
          else if (realAction.equals(Action_Pause)) 
          {
             EventBus.getDefault().post(new PlayControlEvent(PlayControlEvent.PlayAction.PAUSE));    
          } 
          else if (realAction.equals(Action_Close)) 
          {
              EventBus.getDefault().post(new ShutdownEvent());
          }
          else if ( realAction.equals(Action_Next))
          {
             EventBus.getDefault().post(new PlayControlEvent(PlayControlEvent.PlayAction.NEXT_CHANNEL));
          }
          else if ( realAction.equals(Action_Previous))
          {
             EventBus.getDefault().post(new PlayControlEvent(PlayControlEvent.PlayAction.PREVIOUS_CHANNEL));
          }
      }
   }
}