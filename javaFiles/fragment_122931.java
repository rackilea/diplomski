public class Oscillo implements MessageListener{
    Data data;
    Window window;

    //get b1 or b2 by window.getB1() and window.getB2() accordingly

   Window getWindow() { return window; }

}//end class

class Data{
    private Oscillo parent;
    Data (Oscillo parent){
       // might be worth checking if window is not null,
       // depending on your architecture and invariants
       parent.getWindow().getB1();
    }
    ...
}//end class