public class Updater implements Runnable {
    private JTextArea textArea;

    public Updater(JTextArea textArea){
        this.textArea = textArea;
    }

    @Override
    public void run(){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                            //do what you've got to do....
                textArea.setText("New Text");
            }
        });
    }

}