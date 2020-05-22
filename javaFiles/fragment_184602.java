public class Names {
    public static void main(String[] args) {
        SimpleFrame frame = new SimpleFrame();
        frame.setTitle("Multi Thread Workers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
class SimpleFrame extends JFrame {
   public static final int HEIGHT = 500;
   public static final int WIDTH = 600;
   public JTextArea jta;

   public SimpleFrame() {
       setSize(WIDTH, HEIGHT);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new BorderLayout());

       JPanel topPanel = new JPanel();
       final JButton tim = new JButton("Tim (5 sec)");
       final JButton suzy = new JButton("Suzy (3 sec)");
       final JButton edna = new JButton("Edna (2 sec)");
       topPanel.add(tim);
       topPanel.add(suzy);
       topPanel.add(edna);
       add(topPanel, BorderLayout.NORTH);

       JPanel textPanel = new JPanel();
       jta = new JTextArea(10, 10);
       jta.setFont(new Font("SansSerif", Font.PLAIN, 20));
       JScrollPane jsp = new JScrollPane(jta);
       add(jsp, BorderLayout.CENTER);

       tim.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               Runnable r1 = new myRunnable(5, "Tim", "Tim", 5000,
                    SimpleFrame.this, jta);
               Thread t1 = new Thread(r1);
               t1.start();
               tim.setEnabled(false);
           }
       });

       suzy.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               Runnable r2 = new myRunnable(3, "Suzy", "Suzy", 3000,
               SimpleFrame.this, jta);
               Thread t2 = new Thread(r2);
               t2.start();
               suzy.setEnabled(false);
           }
       });

       edna.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               Runnable r3 = new myRunnable(1, "Edna", "Edna", 1000,
                       SimpleFrame.this, jta);
               Thread t3 = new Thread(r3);
               t3.start();
               edna.setEnabled(false);
           }
       });
       jta.setVisible(true);
       jsp.setVisible(true);
       topPanel.setVisible(true);
       setVisible(true);
   }
}
class myRunnable implements Runnable {
int workerTime;
String name;
String threadToRun;
int runtimeDelay;
JFrame frame;
JTextArea jTextArea;

public myRunnable(int time, String workerName, String thread, int delay,
        JFrame f, JTextArea j) {
    workerTime = time;
    name = workerName;
    threadToRun = thread;
    runtimeDelay = delay;
    frame = f;
    jTextArea = j;
}

public void run() {
    int i = 0;

    while (i < 10) {
        try {
            jTextArea.append(name + " is working, count = " + workerTime);
            workerTime += workerTime;
            frame.repaint();
            Thread.sleep(runtimeDelay);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
}
}