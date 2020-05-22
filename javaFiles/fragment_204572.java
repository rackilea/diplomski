import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class GUI implements ActionListener {

    private JButton startBtn, stopBtn;
    private Caller caller;

    public GUI() {

        JFrame frame = new JFrame("Caller GUI");
        frame.setPreferredSize(new Dimension(400,300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel_1 = new JPanel();
        startBtn = new JButton("Start");
        startBtn.addActionListener(this);
        panel_1.add(startBtn);

        stopBtn = new JButton("Stop");
        stopBtn.addActionListener(this);
        stopBtn.setEnabled(false);
        panel_1.add(stopBtn);
        frame.add(panel_1);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == startBtn) {
            caller = new Caller(); //create swing worker 
            caller.execute(); // run it 
            stopBtn.setEnabled(true); //disable, enable buttons 
            startBtn.setEnabled(false);
        }
        if(e.getSource() == stopBtn) {
            caller.stop();
            stopBtn.setEnabled(false);
            startBtn.setEnabled(true);
        }
    }

    public static void main(String[] args) {

        new GUI();
    }
}

class Caller extends SwingWorker<Void, Void>{

    private int counter = 0;
    private boolean isStoped = false;

    void stop() {isStoped = true; }

    @Override
    protected Void doInBackground() throws Exception {

        while (! isStoped ) {
            System.out.println(counter ++); //just print values 
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {   e.printStackTrace(); }
        }
        return null;
    }
}