public class Response<T> {
    private T message;
    private Exception ex;

    public Exception getEx() {
        return ex;
    }

    public void setEx(Exception ex) {
        this.ex = ex;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}


@Controller
public class MyControllerController {
    private Response<String> _response;
    private String message;

    public MyController() { _response = new Response<>(); }

 @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public @ResponseBody Response<String> signup(@RequestBody UserSignup details) {
        try{
            message = "";
             // code...
            _response.setMessage(message);
            return _response;
        }catch (Exception ex){
            _response.setEx(ex);
            return _response;
        }
    }
}