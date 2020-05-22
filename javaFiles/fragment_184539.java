public class FlashLight{
private CameraManager camManager;
static Context myContext;

// Called From C# to get the Context Instance
public static void receiveContextInstance(Context tempContext) {
        myContext = tempContext;

 this.camManager = (CameraManager)   myContext.getSystemService(context.CAMERA_SERVICE);
    }

public static boolean enableFlash(){
        try {
            camManager.setTorchMode("0", true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
    }
    return true;
}

public static boolean stopFlash(){
        try {
            camManager.setTorchMode("0", false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
    }
    return true;
}
}