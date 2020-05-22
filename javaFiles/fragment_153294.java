public class WheelValidator{
    private List<ValdiatorObserver> observers = new ArrayList<ValidatorObserver>();

    public void addObserver(ValidatorObserver observer){
       observers.add(observer);
    }

    public void validate(){
       //if validation fails
       for(ValidationObserver observer: observers){
          observers.notify(1); //1 is an error code
       }
    }
}