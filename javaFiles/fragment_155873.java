public class SecondJPanel extend JPanel{

    public void SecondJPanel(){
        init();
    }
    private void init(){
        FirstJPanel first = new FirstJPanel();
        first.addMyButtonActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "My button in the FirstJPanel Click!");
            }
        });
    }
}