import com.google.gson.Gson;

public Resolution autocomplete() {

    List<String> opts = new ArrayList<String>();

    ...

    String json = new Gson().toJson(opts);
    return new StreamingResolution("application/json",json);
}