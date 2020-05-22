public class YourClass{
    public void aMethod (){
        FaceBookClass fb = new FaceBookClass ();
        fb.setListenerToF (new FaceBookClass.FListener (){
            @Override
            void theCallback (Result aResult){
                //Do something with result
            }
        });
        fb.f ();

    }
}

public class FaceBookClass{
    public static interface FListener{
        void theCallback (Result aResult);
    }

    public void f (){
        ...
    }

    public void setListenerToF (FListener listener){
        ...
    }
}