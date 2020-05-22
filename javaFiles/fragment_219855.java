...
static FileFilter txtFile;
static JFileChooser save;

static {
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (ClassNotFoundException | 
           InstantiationException | 
           IllegalAccessException | 
           UnsupportedLookAndFeelException e) {
        e.printStackTrace();
    }
    save = new JFileChooser(System.getProperty("user.home//documents"));
}

public static void main(String[] args)  {
    frame = new JFrame();
    pane = frame.getContentPane();
    ...
    ...