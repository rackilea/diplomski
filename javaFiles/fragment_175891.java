import com.google.gson.Gson;

public class ErrorModel {
  public int ErrorCode;
  public String Message;
  public static void main(String[] args) {
    String json = "{\"ErrorCode\":1005,\"Message\":\"Username does not exist\"}";
    Gson gson = new Gson();
    ErrorModel err = gson.fromJson(json, ErrorModel.class);
    System.out.println(err.ErrorCode);
    System.out.println(err.Message);
  }
}