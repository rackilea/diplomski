public class DisplayElementHandler {
      private Activity activity;
      public DisplayElementHandler(Activity activity) {
           this.activity = activity;
      }

      public void Initialise(){ //initialise all display elements
           txtUserID = (EditText) activity.findViewById(...);
      }
 }