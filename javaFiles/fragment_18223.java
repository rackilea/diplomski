public class YourProject extends JFrame implements ActionListener{

JtextField text = new JtextField();
JButton post = new JButton("POST");

public YourProject(){

add(text);
add(post);
post.addactionlistener(this);
setVisible(true);

}



 @Override
public void actionPerformed(ActionEvent e) {

if(e.getSource()==post) {

String removed = text.getText().trim();

System.out.println(removed);

}