public class SampleClass {
private DataInterface mListener;

public SampleClass() {
    super();
}

public void getDataForId(final String id) {
    ApiInterface apiInterface = APIClient.getApiInterface();
    Call<MyResponse> call = apiInterface.getResponse();
    call.enqueue(new Callback<MyResponse>() {
        @Override
        public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
            if (response!=null && response.body() != null && mListener != null) {
                mListener.responseData(response.body());
            }
        }
        @Override
        public void onFailure(Call<MyResponse> call, Throwable t) {

        }
    });
}

public void setOnDataListener(DataInterface listener) {
    mListener = listener;
}

public interface DataInterface {
    void responseData( MyResponse myResponse );
}
}