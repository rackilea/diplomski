public class User {
     public interface ChangeListener {
         void onChanged(User user);
     }

     private List<ChangeListener> changeListeners = new CopyOnWriteArrayList<>();

     public void addChangeListener(ChangeListener listener) {
         this.changeListeners.add(listener);
     }

     public void removeChangeListener(ChangeListener listener) {
         this.changeListeners.remove(listener);
     }

     private String firstName;
     private String lastName;

     public void setFirstName(String firstName) {
         this.firstName = firstName;
         for(ChangeListener changeListener: changeListeners) {
             changeListener.onChanged(this);
         }
     }
}