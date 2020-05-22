@Override
public void handle(Request request, Response response) {

    String type = request.getMethod().getName();
    String uid= (String) request.getAttributes().get("uid");

    if(type.equalsIgnoreCase("get"))
    {
          (do you processing here)
    }
}