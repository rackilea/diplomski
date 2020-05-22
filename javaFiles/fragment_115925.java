public static void showMyPane(final String[] TEXT) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, TEXT[0] 
                      + "\n is on EDT: " + SwingUtilities.isEventDispatchThread(), TEXT[1],
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }//end showMyPane

    public static void main(String[] args) {
        final String[] TEXT = {
            //message
            "Hello, World!",
            //title
            "Greeting"};//end TEXT
        showMyPane(TEXT);
    }