import java.util.Observable;
import java.util.Observer;

public class SampleObserver implements Observer {

    public void startObservingGlobals() {
        GlobalValues.getInstance().addObserver( this );
    }

    public void stopObservingGlobals() {
        GlobalValues.getInstance().deleteObserver( this );
    }

    public void doTryMe( boolean newSeeMe ) {
        // do something when seeMe changes
    }

    @Override
    public void update(Observable observable, Object object) {
        if( observable instanceof GlobalValues ) {
            if( object != null && object instanceof GlobalValues.ValueKey ) {
                switch( ( (GlobalValues.ValueKey)object ).getKey() ) {
                case NONE:
                    // General Notification
                    break;
                case SEEME:
                    doTryMe( GlobalValues.getInstance().getSeeMe() );
                    break;
                case OTHERVALUE:
                    // do something else
                    break;
                }
            }
        }
    }

}