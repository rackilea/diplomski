public class CustomStringRequest extends StringRequest {
    private String action;

    public CustomStringRequest(int method, String url, String action, Response.Listener listener, Response.ErrorListener el) {
        super(method, url, listener, el);
        this.action = action;
    }

    @Override
    protected Map<String, String> getParams() {
        Map<String, String> parmas = new HashMap<>();

        //here we pass params
        parmas.put("action", action);

        return parmas;
    }
}