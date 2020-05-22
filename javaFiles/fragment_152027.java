public interface IResult {
    public void notifySuccess(String requestType,JSONObject response);
    public void notifySuccess(String requestType,JSONArray response);
    public void notifyError(String requestType,VolleyError error);
}
// added a new method "notifySuccess" where params are requestType & JSONArray response