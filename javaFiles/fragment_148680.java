public class MediaKeyHandler extends MediaKeyListener {

    public MediaKeyHandler() {
        // use this to register for events while in the background:
        UiApplication.getUiApplication().addMediaActionHandler(this);
        // use this to register for events while in the foreground:
        //UiApplication.getUiApplication().addKeyListener(this);
    }

    public boolean mediaAction(int action, int source, Object context) {
        System.out.println("mediaAction(" + action + "," + source + ",context)");

        if (source == MediaActionHandler.SOURCE_BACKGROUND_KEY) {
            switch (action) {
            case MediaActionHandler.MEDIA_ACTION_VOLUME_DOWN:
                // handle volume down key pressed
                break;
            case MediaActionHandler.MEDIA_ACTION_VOLUME_UP:
                // handle volume up key pressed
                break;
            case MediaActionHandler.MEDIA_ACTION_NEXT_TRACK:
                // handle volume up key long-pressed
                break;
            case MediaActionHandler.MEDIA_ACTION_PREV_TRACK:
                // handle volume down key long-pressed
                break;
            default:
                break;
            }
            return true;  // keypress consumed
        } else {
            // keypresses while app is in foreground come here

            return false;  // keypress not consumed
        }
    }