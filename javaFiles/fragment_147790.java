public interface DialogCallback {
    void ok();
    void cancel();
}

public class MyModelessDialog extends JDialog {
    private final DialogCallback cbk;
    private JButton okButton, cancelButton;        

    public MyModelessDialog(DialogCallback callback) {
        cbk = callback;
        setModalityType(ModalityType.MODELESS);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        };

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        };

        // Treat closing the dialog the same as pressing "Cancel":
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)  {
                onCancel();
            }
        };
    }

    private void onOK() {
        cbk.ok();
    }

    private void onCancel() {
        cbk.cancel();
    }
}