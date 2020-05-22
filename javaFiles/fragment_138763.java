public class MyObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof XXX){
            XXX observable = (XXX) o;
            System.out.println("Light: " + observable.send());
            System.out.println("Light status: " + observable.sendst());
        }
    }
}