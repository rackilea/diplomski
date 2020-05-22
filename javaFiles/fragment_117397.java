public interface IUpdateListener{
    public void update();
}


public class Main{

    public static ArrayList<IUpdateListener> listeners = new ArrayList<IUpdateListener>();

    public static void main(String[] args){
        listeners.add(new InputListener());
        while(true){
            for(IUpdateListener listener : listeners){
                listener.update();
            }
        }
    }
}

public class InputListener implements IUpdateListener{
    public void update(){
        // Handle user input here etc
    }
}