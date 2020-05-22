public class HelloCallBack<T> implements AsyncCallback<T> {

private HelloDataProvider<T> dataProvider;

@Override
public void onFailure(final Throwable caught) {

    dataProvider.updateRowData(0, new ArrayList<T>());

}

@Override
public void onSuccess(final T result) {
    // TODO Auto-generated method stub

}

public HelloDataProvider<T> getDataProvider() {
    return dataProvider;
}

public void setDataProvider(final HelloDataProvider<T> dataProvider) {
    this.dataProvider = dataProvider;
}

}