public Form1() {
    initializeComponents();
    addWindowListener(new WindowAdapter() {
        @Override
        public void windowOpened(WindowEvent arg0) {
            //Read data (Depends on the method you choose to save)
            Label label = new Label(data);
            add(label);
        }
    });
}