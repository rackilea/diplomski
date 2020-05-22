// The interface
interface CallBack {
    public void onFinish(String response);
}

// The activity (which calls Cargar_Imagen) should implement CallBack
public class MainActivity extends Activity implements CallBack

    public void onFinish(String response) {
        // here the method did finish, do something with the string
    }

    // somewhere you call to Cargar_Imagen
    String s = ci.Cargar_Imagen(params..., this);
}

// the method signature should receive a CallBack
public String Cargar_Imagen(final String email, final String id, final String f1, final Context context, final String type, final View v, final CallBack callback){
    /* code .... */

    // ...
    // in your onResponse
    callback.onFinish(sBitmap);