frame.addWindowStateListener(new WindowStateListener() {
    public void windowStateChanged(WindowEvent e) {
        System.out.println(frame.getExtendedState());
        if(frame.getExtendedState() == Frame.MAXIMIZED_BOTH){
            System.out.println("The JFrame is maximised");
        }
    }
});