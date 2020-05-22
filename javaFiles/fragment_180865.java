import java.util.Observable;

public class GlobalValues extends Observable {

    private static GlobalValues mInstance = null;

    public static GlobalValues getInstance() {
        if( mInstance == null )
            mInstance = new GlobalValues();

        return mInstance;
    }

    public enum ValueName { NONE, SEEME, OTHERVALUE };

    static class ValueKey {
        private ValueName mValueName;

        public ValueKey( ValueName valueName ) {
            mValueName = valueName; 
        }

        public ValueName getKey() { return mValueName; }
    }



    private boolean mSeeMe = false;

    public boolean getSeeMe() { return mSeeMe; }

    public void setSeeMe( boolean value ) {
        if( value != mSeeMe ) {
            mSeeMe = value;
            this.setChanged();
            this.notifyObservers( new ValueKey( ValueName.SEEME ) );
        }
    }

}