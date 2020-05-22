import java.awt.BorderLayout;

public class Main extends JFrame implements PropertyChangeListener {

    private JPanel contentPane;
    private JButton btnCopy;
    private JFileChooser selectFile;
    private JFileChooser chooseDestination;
    private File selectedfile;
    private File chosenDestination;
    private JProgressBar progressBar;
    private Copy copy;

    class Copy extends SwingWorker<Void, Void> {
        @Override
        protected Void doInBackground() throws Exception {
            int answer = selectFile.showOpenDialog(Main.this);
            if (answer == 0) {
                Main.this.selectedfile = selectFile.getSelectedFile();
                int answer2 = chooseDestination.showSaveDialog(Main.this);
                if (answer2 == 0) {
                    Main.this.chosenDestination = chooseDestination
                            .getSelectedFile();
                    try {
                        FileInputStream fileInputStream = new FileInputStream(
                                selectedfile);
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                                fileInputStream);
                        ProgressMonitorInputStream progressMonitorInputStream = new ProgressMonitorInputStream(
                                Main.this, "Copying", bufferedInputStream);
                        File outputFile = new File(chosenDestination
                                + selectedfile.getName());
                        FileOutputStream fileOutputStream = new FileOutputStream(
                                outputFile);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                                fileOutputStream);
                        int data;
                        byte[] buffer = new byte[1024];
                        while ((data = progressMonitorInputStream.read(buffer)) > 0) {
                            bufferedOutputStream.write(buffer);                         }
                        bufferedOutputStream.close();
                        progressMonitorInputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
            btnCopy.setEnabled(true);
            setCursor(null); // turn off the wait cursor
        }
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * 
     * @throws UnsupportedLookAndFeelException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public Main() throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 130, 135);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new MigLayout("", "[89px][][][][][][][]", "[23px][][]"));

        btnCopy = new JButton("Copy");
        btnCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                copy = new Copy();
                copy.addPropertyChangeListener(Main.this);
                copy.execute();
            }
        });
        panel.add(btnCopy, "cell 1 1,grow");
        selectFile = new JFileChooser();
        chooseDestination = new JFileChooser();
        chooseDestination.setFileSelectionMode(2);
        pack();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);
        }
    }
}