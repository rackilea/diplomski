@RequestScoped
@ManagedBean
public class MrBean {
    private String oldValue;
    private String newValue;

    public void doSeomthing() {
       if (oldValue != null) {
           // Do whatever you need when oldValue is not null here
       } else {
           // 1st request will have oldValue == null
       }

       oldValue = newValue; // Update the oldValue with newValue
    }

    // Getters and Setters
}