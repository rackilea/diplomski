public class GUI extends JFrame implements ActionListener{
    //...
    Button b;
    public GUI(){
        //...
        b = new Button();
        this.getContentPane().add(b);
        this.addListener(b);
        //...
    }
    //...
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b){
            // your TODO list here
        }
    }
}