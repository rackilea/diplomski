public class Main extends AppCompatActivity 
{
    SurfaceView cameraView;
    TextView textView;
    CameraSource cameraSource;
    final int RequestCameraPermissionID = 1001;

    // you have to put it into a method. 
    public void myMethod() {
        Message[] dbmessage;
        dbmessage = new Message[300];
        dbmessage[0] = new Message("TEST MESSAGE",  Message.Type.warning,Message.Actions.no,1);
    }
}