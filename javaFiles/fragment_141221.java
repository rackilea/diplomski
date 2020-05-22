static JButton button1 = new JButton("Test");
  static JPanel panel1 = new JPanel():
  public static void main(String[] args{
  panel1.add(button1);
  }
  public void ActionListener(ActionEvent e){
  if(e.equals("Test"){
  panel1.remove(button1);
  panel1.add(radiobutton1);
  }