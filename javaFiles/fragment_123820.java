public interface CalligraphyManager {
    /**
     *  Called on app start up to initialize
     */
     void init();

     // other methods, like wrapping context for activity
     Context wrap(Context context);
}