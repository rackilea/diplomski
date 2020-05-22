public class MyButton extends JComponent implements MouseListener {

    //private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();

    public MyButton(String staticImage, String rolledImage, String clickedImage) {
        //...
    }

    public void addActionListener(ActionListener listener) {
        listenerList.add(ActionListener.class, listener);
    }

    public void removeActionListener(ActionListener listener) {
        listenerList.remove(ActionListener.class, listener);
    }