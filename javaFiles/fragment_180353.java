import java.beans.PropertyChangeEvent;
     import java.beans.PropertyVetoException;
     import java.beans.VetoableChangeListener;

    public class Registrar implements VetoableChangeListener {
         int age;
    @Override
    public void vetoableChange(PropertyChangeEvent event)
        throws PropertyVetoException {
    if (event.getPropertyName().equals("age")) {
        String proposedAge = (String)event.getNewValue();
            age = Integer.parseInt(proposedAge);
          if (age >=18 ) {
               throw new PropertyVetoException("Adult  should be  transferred.", event);
        }
    }
}