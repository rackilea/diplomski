import java.util.prefs.*;

    public class Example {

        public static final int a = 10;

        public void savePreference(int value) {
           Preferences prefs = Preferences.userNodeForPackage(Example.class);                
           prefs.put(a, value); 
        }

        public int readPreference() {
           Preferences prefs = Preferences.userNodeForPackage(Example.class);
           return prefs.get(a, "default");  
        }  

        public void main (String args[]){

        // Read 
        myValue = readPreferences();

        // Modify 
        myValue = myValue + 6;

        // Save
        savePreferences(myValue);            

        }

    }