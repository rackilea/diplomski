public class HelloDataProvider<T> extends AsyncDataProvider<T> {

@Override
protected void onRangeChanged(final HasData<T> display) {

    final HelloCallBack<T> callBack = new HelloCallBack<T>();
    callBack.setDataProvider(this);

}

}