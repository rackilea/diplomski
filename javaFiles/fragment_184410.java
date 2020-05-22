public class RegenerateToken {

public interface Callback {
    public void onResponce(String data);
}

public void generate(Context context,final Callback callBack) {
    ExecuteServerReq executeServerReq = new ExecuteServerReq(context, client, Utilz.URL + "/authenticate", params, true, true);
    executeServerReq.execute();
    executeServerReq.getResponse = new ExecuteServerReq.GetResponse() {

    @Override
    public void onResponse(String objects) {
        Utilz.printLog("RegenerateTokenresponse", objects);
        callBack.onResponce(objects);
    }};
}
}