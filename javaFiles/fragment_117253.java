public class MainApp extends JFrame{
    public MainApp(){
        JavaBrowser browser = new JavaBrowser();
        ToolBar toolbar = new ToolBar(browser);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(browser, BorderLayout.CENTER);
        panel.add(toolbar, BorderLayout.NORTH);

        add(panel);
    }
}

public class ToolBar extends JPanel{
    public ToolBar(final JavaBrowser browser){
        super(new BorderLayout());
        JTextField addressBar = new JTextField("...");
        addressBar.addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e){ browser.loadContent(event.getActionCommand()); }
        });
        add(addressBar, BorderLayout.CENTER);
    }
}

public class JavaBrowser extends JPanel{
    public JavaBrowser(){
        super(new BorderLayout());
        JEditorPane editor = new JEditorPane();
        // set up all your stuff like properties and listeners to the editor
        add(editor, BorderLayout.CENTER);
    }

    // other methods such as loadContent(...)
}