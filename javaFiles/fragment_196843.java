public abstract class RetrofitCallback<T> implements Callback<T> {
private BaseActivity mContext;

public RetrofitCallback(Context context) {
    mContext = (BaseActivity) context;
}

@Override
public void onResponse(Call call, Response response) {
    mContext.hideLoading();
    onSuccess(response);
}

@Override
public void onFailure(Call call, Throwable t) {
    mContext.hideLoading();
}

public abstract void onSuccess(@NonNull Response<T> response);