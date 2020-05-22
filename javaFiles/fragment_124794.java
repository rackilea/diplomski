import org.json.JSONException;
import org.json.JSONObject;

public class JSONExceptionHelper {

    private static final String KEY_MESSAGE = "Message";
    private static final String KEY_EXCEPTIONTYPE = "ExceptionType";
    private static final String KEY_STACKTRACE = "StackTrace";

    public static boolean isException(JSONObject json) {
        return json == null 
            ? false
            : json.has(KEY_MESSAGE) && 
              json.has(KEY_EXCEPTIONTYPE) && 
              json.has(KEY_STACKTRACE);
    }

    public static void ThrowJsonException(JSONObject json) throws JSONException {

        String message = json.getString(KEY_MESSAGE);
        String exceptiontype = json.getString(KEY_EXCEPTIONTYPE);
        String stacktrace = json.getString(KEY_STACKTRACE);

        StringBuilder sb = new StringBuilder();
        sb.append(exceptiontype);
        sb.append(": ");
        sb.append(message);
        sb.append(System.getProperty("line.separator"));
        sb.append(stacktrace);

        throw new JSONException(sb.toString());
    }

}