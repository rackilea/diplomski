Ion.with(context)
.load("https://developers.zomato.com/api/v2.1/geocode?lat=25.12819&lon=55.22724")
.asJsonObject()
.setCallback(new FutureCallback<JsonObject>() {
@Override
public void onCompleted(Exception e, JsonObject result) {
    // do stuff with the result or error
}
 });