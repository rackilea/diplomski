@WebService
public class WhatsMyName {

@WebMethod
@WebResult(name = "Name")
public String getMyName(){
    return "John Smith";
}