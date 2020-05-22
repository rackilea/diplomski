public class LoginCallback implements Callback{
    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            final int code = response.code();
            if (code == 200) {
            ...
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
         if (t instanceof IOException) {
            listener.noNetworkFailure();
           ...
    }
}