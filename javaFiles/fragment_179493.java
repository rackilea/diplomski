public class MyButton extends JButton implements ActionListener{
boolean pressed = false;
public MyButton(String name){
    super(name);
    this.addActionListener(this);
    }
@Override
public void actionPerformed(ActionEvent e){
    if(pressed){
    pressed = !pressed;
    _change_text_on_button_
    _do_job_
    }
}