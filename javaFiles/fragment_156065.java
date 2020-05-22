// Should not extend MainActivity 
public  class ListenersUtils {

    public static View.OnClickListener getListener(final MainActivity main, String listenerName) {
        switch (listenerName) {
            case "button1":
                return new View.OnClickListener() {
                    @Override
                    public void onClick(View view ) {
                        //some code that can reference MainActivity
                    }
                };
            default:
                break;
        }
        return null;
    }
}