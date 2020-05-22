import android.support.annotation.Nullable;
import android.util.Log;

import com.arsdigitech.angpau.R;
import com.arsdigitech.angpau.appClasses.App;
import com.google.gson.JsonSyntaxException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetroService {
    public static final String TAG = "RetroService***";

    public <T> void call(Call<T> call, OnResponseListenerRetro<T> onResponseListener) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful()) {
                    onResponseListener.onSuccess("", response.body());
                } else {
                    ErrorType errorType = ErrorType.getErrorTypeByVolleyError(response.code());
                    onResponseListener.onError("", errorType);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.e(TAG, t.getMessage());
                if (t instanceof JsonSyntaxException) {
                    onResponseListener.onError("", ErrorType.ParseError);
                } else {
                    onResponseListener.onError("", ErrorType.Error);
                }
            }
        });
    }


    public enum ErrorType {
        Error(R.string.error),
        RequestTimeoutError(R.string.timeoutError),
        NoConnectionError(R.string.noConnectionError),
        AuthFailureError(R.string.authFailureError),
        ServerError(R.string.serverError),
        NetworkError(R.string.networkError),
        BadRequestError(R.string.badRequestError),
        ForbiddenError(R.string.forbiddenError),
        NotFoundError(R.string.notFoundError),
        UnsupportedMediaType(R.string.unsupportedMediaType),
        MethodNotAllowedError(R.string.methodNotAllowedError),
        ParseError(R.string.parsing_error),;
        int message;

        ErrorType(int message) {
            this.message = message;
        }

        public String getMessage() {
            return App.getAppRes().getString(message);
        }

        public static @Nullable
        ErrorType getErrorTypeByVolleyError(int errorCode) {
            ErrorType errorType = null;
            switch (errorCode) {
                case 400:
                    errorType = ErrorType.BadRequestError;
                    break;
                case 401:
                    errorType = ErrorType.AuthFailureError;
                    break;
                case 403:
                    errorType = ErrorType.ForbiddenError;
                    break;
                case 404:
                    errorType = ErrorType.NotFoundError;
                    break;
                case 408:
                    errorType = ErrorType.RequestTimeoutError;
                    break;
                case 500:
                case 501:
                case 502:
                case 503:
                case 504:
                case 505:
                    errorType = ErrorType.ServerError;
                    break;
                default:
                    errorType = ErrorType.Error;
            }
            return errorType;
        }
    }

    public interface OnResponseListenerRetro<T> {
        void onSuccess(String tag, T response);
        void onError(String tag, ErrorType error);
    }

}