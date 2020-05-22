public class RestResponse {
    private final boolean success;
    private final String message;

    public RestResponse(final boolean success, final String message)
    {
      this.success = success;
      this.message = message;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public String getMessage()
    {
      return message,
    }
}