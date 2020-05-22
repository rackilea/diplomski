@SuppressWarnings("serial")
public class GetImageAction extends AbstractAction {
    private JFrame myFrame;
    private OpenSave openSave;

    public GetImageAction(String name, JFrame myFrame, OpenSave openSave) {
        super(name);
        this.myFrame = myFrame;
        this.openSave = openSave;
        int mnemonic = (int) name.charAt(0);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser escolher = new JFileChooser();
        escolher.setMultiSelectionEnabled(false);
        escolher.setCurrentDirectory(new File("."));
        escolher.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {
                return "Imagens JPG and PNG";
            }

            @Override
            public boolean accept(File f) {
                String ext = f.getName().toLowerCase();
                if (f.isDirectory() || ext.endsWith(".jpg") || ext.endsWith(".png")) {
                    return true;
                }
                return false;
            }
        });
        int reply = escolher.showOpenDialog(myFrame);
        if (reply == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage img = ImageIO.read(escolher.getSelectedFile());
                openSave.setImagem(img);
                myFrame.pack();
                myFrame.setLocationRelativeTo(null);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}