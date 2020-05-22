public static void main(String[] args){
    Action buttonListener = new Action() {
         public void actionPerformed(ActionEvent e) {
                //Perform function f    
         }
    };
    button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke("ENTER"), "test");
    button.getActionMap().put("test", buttonListener);
    button.addActionListener(buttonListener);
}