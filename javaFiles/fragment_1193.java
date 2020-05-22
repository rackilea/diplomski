public class GetWeather { 


private static String WEATHER_URL = "http://api.wunderground.com/api/706d22f330042323/conditions/q/"; 

public String weather; 
public String temperature_string; 
public Bitmap weather_icon; 

public GetWeather() { 

} 
public GetWeather(String city, String state){ 

city = city.replaceAll(" ", "_"); 
//construct post URL 
final String GET_WEATHER_URL = WEATHER_URL + state + "/" + city + ".json"; 
new Thread(new Runnable() 
{ 
public void run() 
{ 
String request = GET_WEATHER_URL; 
HttpResponse rp = null; 
JSONObject jObject = null; 
try 
{ 
HttpClient httpclient = new DefaultHttpClient(); 
httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1); 
HttpGet request1 = new HttpGet("http://api.wunderground.com/api/706d22f330042323/conditions/q/CA/Anuradhapura.json"); 
HttpResponse response = httpclient.execute(request1); 
HttpEntity resEntity = response.getEntity(); 
String _response=EntityUtils.toString(resEntity); 
jObject = new JSONObject(_response); 
JSONObject current_observation = jObject.getJSONObject("current_observation"); 
weather = current_observation.getString("weather"); 
Log.i("..............",""+weather); 
temperature_string = current_observation.getString("temperature_string"); 
String icon_url = current_observation.getString("icon_url"); 
weather_icon = get_weather_icon(icon_url); 

}catch(Exception e) 
{ 
e.printStackTrace(); 
} 


} 
}).start(); 
} 

public static Bitmap get_weather_icon(String url){ 
Bitmap bitmap = null; 
InputStream in = null; 
BufferedOutputStream out = null; 

try { 

bitmap = BitmapFactory.decodeStream((InputStream)new URL(url).getContent()); 

} catch (MalformedURLException e) { 
e.printStackTrace(); 
} catch (IOException e) { 
e.printStackTrace(); 
} 

return bitmap; 

} 

}