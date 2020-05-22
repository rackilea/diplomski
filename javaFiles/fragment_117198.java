public class Bold extends JTextPane {       

    public Bold(){
        super();

        setEditorKit(new HTMLEditorKit());
        setText("<html><h1>Example</h1><p>Just a test</p></html>");
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_MASK), "bold");
        getActionMap().put("bold", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JTextPane bold = (JTextPane) e.getSource();
                int start = bold.getSelectionStart();
                int end = bold.getSelectionEnd();
                String txt = bold.getSelectedText();
                if(end != start)
                    try {
                        bold.getDocument().remove(start, end-start);
                        HTMLEditorKit htmlkit = (HTMLEditorKit) bold.getEditorKit();
                        htmlkit.insertHTML((HTMLDocument) bold.getDocument(), start, "<b>"+txt+"</b>", 0, 0, HTML.Tag.B);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
            }

        });
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            JFrame f = new JFrame();
            f.setContentPane(new Bold());
            f.setPreferredSize(new Dimension(640,480));
            f.pack();
            f.setVisible(true); 
        });
    }
}