public class MyActivity implements MyCustomInterface {

@Override
public void sendData(String str){

Handler handler = new Handler(Looper.getMainLooper());
handler.post(new Runnable() {
  @Override
  public void run() {
    recived_message.setText(str);
  }
});
}
}