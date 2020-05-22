// This needs to become an instance method (non static) in this example in
// order to access the frame
public void runGui() {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            // Refresh your component here. Here I'm redrawing the
            // content pane

            frame.getContentPane().repaint();
        }
    });
}