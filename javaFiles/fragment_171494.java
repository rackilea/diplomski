import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.concurrent.TimeUnit;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

public class Loader implements Runnable {
    static JFrame frame = new JFrame();
    Frame parentUI = new Frame();
    JDialog dialog = new JDialog();
    JLabel lbl_filename = new JLabel();
    JLabel lbl_path = new JLabel();

    static Loader load = new Loader(null);

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        load.run();
        frame.setVisible(true);
    }

    public Loader(Frame parent) {
        init();
        parentUI = parent;
    }

    @Override
    public void run() {
        createDialog(parentUI);
    }

    public final void init() {
        JButton btn = new JButton("Open");

        frame.setTitle("Loader Test");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        btn.addActionListener(new Action1());

        frame.add(btn);
        frame.add(lbl_filename);
        frame.add(lbl_path);
    }

    class Action1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            openFile();
        }
    }

    private void createDialog(final Frame parent) {

        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setTitle("Loader");

        JLabel label = new JLabel("Label");
        dialog.add(label);

        dialog.pack();
        dialog.setLocationRelativeTo(parent);
    }

    public void show(Boolean visible) {
        this.run();
        dialog.setVisible(visible);
    }

    public void close() {
        dialog.setVisible(false);
    }

    private void openFile() {
        System.out.println("Loading file...");

        // !! load.show(true);

        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // createDoc(path);
                createDoc(null);
                return null;
            };

            @Override
            protected void done() {
                load.close();
            };
        }.execute();

        load.show(true); //!! 
    }

    private void createDoc(String file) {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}