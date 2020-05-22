public interface ServiceCall
{
  public JsonObject invoke(JsonArray params) throws ServiceCallException;
}

public class ServiceProcessor
{
  private static final Map<String, ServiceCall> SERVICE_CALLS = new HashMap<>();

  static
  {
    SERVICE_CALLS.put("toasty", new ToastCall());
  }

  public String process(String messageStr) 
  {
    try 
    {
      JsonObject message = Json.createReader(new StringReader(messageStr)).readObject();

      if (message.containsKey("method"))
      {
        String method = message.getString("method");

        ServiceCall serviceCall = SERVICE_CALLS.get(method);

        if (serviceCall != null)
        {
          return serviceCall.invoke(message.getJsonArray("params")).toString();
        }
        else
        {
          return fail("Unknown method: " + method);
        }
      }
      else
      {
        return fail("Invalid message: no method specified");
      }
    } 
    catch (Exception e) 
    {
      return fail(e.message);
    }
  }

  private String fail(String message)
  {
    return Json.createObjectBuilder()
      .add("status", "failed")
      .add("message", message)
      .build()
      .toString();
  }      

  private static class ToastCall implements ServiceCall
  {
    public JsonObject invoke(JsonArray params) throws ServiceCallException  
    {
      //make toast here
    }
  }
}