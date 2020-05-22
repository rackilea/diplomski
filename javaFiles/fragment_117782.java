public class SensorAddClient extends Thread implements Runnable {
String[] args = new String[3];

public SensorAddClient(String[] args) {

 this.args = args;

}
@Override
public void run(){
try {
    SensorClient.main(args);//this is the main function i wanna get executed on my args
} catch (IOException e) {
    e.printStackTrace();
} catch (JSONException e) {
    e.printStackTrace();
}}