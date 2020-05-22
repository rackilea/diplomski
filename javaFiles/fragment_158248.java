SwingUtilities.invokeLater(new Runnable(){
    @Override
    public void run() {
        String menuName = (String) JOptionPane.showInputDialog (
            MyFrame.this, // parent component is the JFrame you are launching this from
            "Insert new Menu Name"
        );
        // do stuff with menuName
    }
});