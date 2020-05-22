public class test extends JFrame {
    ... 
    private Listener listener;

    public static interface Listener {
        void setN(int n);
    }

    public void setVisible(Listener listener) throws InterruptedException {
        this.listener = listener;   // <== save reference to listener
        setVisible(true);
    }

    public test() {
        ...
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                listener.setN(5);  // <== call listener
                dispose();

            }
        });
    }