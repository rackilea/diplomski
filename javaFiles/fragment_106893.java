public class A{
    public A (){
        B b = new B (new B.Listener (){
            @Override
            void onResult (String result){
                //result is "Core dumped!"
            }
        });
        b.aMethod ();
    }
}

public class B{
    private final Listener listener;

    public static interface Listener{
        void onResult (String result);
    }

    public B (Listener listener){
        if (listener == null) throw new IllegalArgumentException ("The \"listener\" parameter cannot be null.");
        this.listener = listener;
    }

    public void aMethod (){
        //Do something interesant
        //...
        String error = "Core dumped!"

        //Call the listener
        listener.onResult (error);
    }
}