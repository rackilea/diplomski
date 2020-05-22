public class BluettoothService{

    Activity activity;

    BluettoothService(Activity activity){
    this.activity=activity;
    }
    public void startConnection() {
    // Create an intent for SearchActivity 
    Intent intent = new Intent(activity, SearchActivity.class);
    //start SearchActivity through intent and expect for result. 
    //The result is based on result code, which is REQUEST_DISCOVERY
    activity.startActivityForResult(intent, REQUEST_DISCOVERY);              
    } 


}