@Override protected void configureWindow(java.awt.Window root) {

    root.addWindowListener(new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            // write your code here
            System.out.println("Window Closing"); 
        }

    });
}