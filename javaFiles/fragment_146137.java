import java.awt.Font;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.UIManager;

...

Font f = new Font(Font.DIALOG, Font.PLAIN, 12);
ArrayList<String> excludes = new ArrayList<String>();
Enumeration itr = UIManager.getDefaults().keys();
while(itr.hasMoreElements()){
    Object o = itr.nextElement();
    if(o instanceof String) {
        String key = (String) o;
        Object value = UIManager.get (key);
        if ((value instanceof javax.swing.plaf.FontUIResource)
                && (!excludes.contains(key))){
            UIManager.put (key, f);
        }
    }
}