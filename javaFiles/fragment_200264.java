public class ActionObserver extends Observable {


    public void updateStatus(String message){

        setChanged();
        notifyObservers(message);
    }

}