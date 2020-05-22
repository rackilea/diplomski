public class MyController extends Controller{   
    //1. you store your client channels here
    private static ArrayList<WebSocket.Out> channels=new ArrayList<>();

    public static Result showMyView() {
        return ok(views.html.showMyView.render(Data.all()));
    }

    @BodyParser.Of(play.mvc.BodyParser.Json.class)
    public static Result jsonReceiver() {
        JsonNode json = request().body().asJson();
        String rcvData = json.findPath("someData").textValue();

        if(rcvData != null) {
           //3. you can write in your channels :)
           for(WebSocket.Out channel : channels){
               channel.write("blah");
           }

            return ok();
        } else {
             return badRequest();
        }
    }

    public static WebSocket<String> websocket() {
        return new WebSocket<String>() {

            public void onReady(WebSocket.In<String> in, WebSocket.Out<String> out) {
                  //2. each time a client connects, you save a reference to its channel
                  channels.add(out);
            }
        };
    }