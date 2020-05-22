public class ApplicationExtender extends Application {

    public void toast(String message){
    Toast.makeText(super.getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }

}