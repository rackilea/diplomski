public class SkaExecutionPanel {
    // Anybody who wants to be told when a panel is reset will implement
    // this interface and call addListener().
    public interface Listener {
        void panelReset(SkaExecutionPanel panel);
    }

    // Each panel needs to maintain an internal list of listeners.
    private List<Listener> listeners = new ArrayList<Listener>();

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    public void reset() {
        /* Do your thing. */

        // When something happens that the listeners will care about, such as a
        // call to reset() in this case, you iterate through the list and tell
        // each one what's happened.
        for (Listener listener: listeners) {
            listener.panelReset(this);
        }
    }
}

public class SkaTest {
    public static void main(String args[]) {
        /* Snippety snip. */

        for (i=0; i < alg.length; i++) {
            // Here we need to tell the execPanels that we want to do something
            // whenever somebody calls reset() on them. We will add a listener
            // to each panel that does the terminate/createProgram/start dance.
            // This way we don't have to ask the panels when they are reset; 
            // instead they will tell us when that happens.
            execPanel[i].addListener(new SkaExecutionPanel.Listener() {
                final int index = i;

                public void panelReset(SkaExecutionPanel panel) {
                    alg[index].terminate();
                    createProgram(index);
                    alg[index].start();
                    execPanel[index].unreset();
                }
            });
        }
    }
}