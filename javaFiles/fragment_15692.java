public class MyActivity extends Activity implements Callback , View.OnClickListener {


 @Override
 public void onCreate(Bundle savedState) {
   super.onCreate(savedState);
   findViewById(R.id.DoHttp).setOnClickListener(this);
 } 

 @Override
 public void onClick(View v) {
   if (v.getId(() == R.id.DoHttp) {

     OkHttpClient okHttpClient = new OkHttpClient();

     Request request = new Request.Builder().url("http://publicobject.com/helloworld.txt").build();
     okHttpClient.newCall(request).enqueue(this);
   }
 }


 @Override
 public void onFailure(Request request, IOException e) {
  //do something to indicate error
 }

  @Override
  public void onResponse(Response response) throws IOException {
    if (response.isSuccessful()) {
     parse(response.body().string());
    }
  }

  private void parse(String response) {
   //do something with response
  } 
}