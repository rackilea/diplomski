/**
 * Based on code from: http://www.smartcode.ch/netbeans-hide-show-topcomponent/
 *
 * @author Javier A. Ortiz Bultrón javier.ortiz.78@gmail.com
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@ServiceProvider(service = ViewManager.class)
public class ViewManager {

    private final Map<TopComponent, Mode> hiddenComponents;

    public ViewManager() {
        hiddenComponents = new HashMap<>();
    }

    public synchronized void showTopComponent(Class<? extends TopComponent> topComponentClass) {

        for (Map.Entry<TopComponent, Mode> hiddenComponentEntry : hiddenComponents.entrySet()) {
            TopComponent hiddenComponent = hiddenComponentEntry.getKey();

            if (hiddenComponent.getClass().equals(topComponentClass)) {
                Mode mode = hiddenComponentEntry.getValue();
                WindowManager.getDefault().findMode(mode.getName()).dockInto(hiddenComponent);
                hiddenComponent.open();
                hiddenComponents.remove(hiddenComponent);
                break;
            }

        }
    }

    public synchronized void hideTopComponent(Class<? extends TopComponent> topComponentClass) {

        Set<TopComponent> shownTopComponents = WindowManager.getDefault().getRegistry().getOpened();

        for (TopComponent shownTopComponent : shownTopComponents) {
            if (shownTopComponent.getClass().equals(topComponentClass)) {
                Mode mode = WindowManager.getDefault().findMode(shownTopComponent);

                hiddenComponents.put(shownTopComponent, mode);
                shownTopComponent.close();
            }
        }
    }

    public synchronized void showAll() {
        for (TopComponent tc : hiddenComponents.keySet()) {
            showTopComponent(tc.getClass());
        }
    }

    /**
     * Load a screen role.
     *
     * @param role Role to load.
     */
    public static void loadRole(String role) {
        //Open all components
        Lookup.getDefault().lookup(ViewManager.class).showAll();
        //Change role (this closes the ones not in this role)
        WindowManager.getDefault().setRole(role);
    }
}