// !! class names should begin with upper case letter
public class PdfMerger extends JFrame {
    // ...
    private JButton choose1, choose2, mergeButton;
    // ...

    public PdfMerger() {
        super("PDF Merger");
        setLayout(new BorderLayout());
        setSize(500, 500); // advise against this
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addComponents();
        addAction();
        setVisible(true);

        // !!
        mergeButton.setEnabled(false);
    }

    // ...

    public void addAction() {
        choose1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == choose1) {
                    returnValue1 = fileChooser1.showOpenDialog(null);
                    if (returnValue1 == JFileChooser.APPROVE_OPTION) {
                        file1 = fileChooser1.getSelectedFile();
                        fileName1 = file1.toString();
                        fileName1 = fileName1.replace("\\", "\\\\");
                        System.out.println(fileName1);

                        // !! added
                        mergeButton.setEnabled(bothFilesChosen());
                    }
                }
            }
        });
        choose2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == choose2) {
                    returnValue2 = fileChooser2.showOpenDialog(null);
                    if (returnValue2 == JFileChooser.APPROVE_OPTION) {
                        file2 = fileChooser2.getSelectedFile();
                        fileName2 = file2.toString();
                        fileName2 = fileName2.replace("\\", "\\\\");
                        System.out.println(fileName2);

                        // !! added
                        mergeButton.setEnabled(bothFilesChosen());
                    }
                }
            }
        });

        // ....

    }

    // !!
    private boolean bothFilesChosen() {
        return (file1 != null && file1.exists() && file2 != null && file2.exists());
    }
}