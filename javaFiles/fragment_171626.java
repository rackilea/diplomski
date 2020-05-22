public class MyFrame extends JFrame{

    private JCheckBox box1;

    public MyFrame(){
        box1 = new JCheckBox();     
    }

public void work(){

    if(getbox().isSelected){
    //work
    }else{
    //do else
    }
}

public JCheckBox getbox1(){
    return this.box1;
}

public JCheckBox setSelectedbox1(boolean set){
    getbox1().setSelected(set); 
}