// in some.class.with.Constants
public static final boolean DEV_MODE = true;

// in some other class
import static some.class.with.Constants.DEV_MODE;

if(DEV_MODE){
    Log.d('sometag', 'somemessage');
}