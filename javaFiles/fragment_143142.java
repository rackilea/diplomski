public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(final Object data) {
        for (final Observer observer : observers) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    observer.notify(data);
                }
            }).start();
        }
    }

    public methodCalledBy3rdPartyAPIOnData (ArrayList<DataClass> data){
        notifyObservers((Object)data);
    }
}