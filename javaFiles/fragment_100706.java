public class Test
{
  public static void main(String[] args)
  {
    final Frame frm=new Frame("Add employee");
    Label lbl = new Label();
    frm.add(lbl);
    frm.setSize(350,200);
    frm.setVisible(true);
    frm.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        System.exit(0);
      }
    });
    Panel p = new Panel();
    //Panel p1 = new Panel();
    final Label jFirstName = new Label("first name");
    final TextField lFirstName = new TextField(20);
    final Label jLastName =new Label("last name");
    final TextField lLastName=new TextField(20);
    final Label jAge= new Label("Age");
    final TextField lAge = new TextField(20);
    final Label jDate =new Label("Date");
    final TextField lDate=new TextField(20);
    final Label jType = new Label("employee type");
    final TextField lType = new TextField(20);
    p.setLayout(new GridLayout(7,1));

    p.add(jFirstName);
    p.add(lFirstName);
    p.add(jLastName);
    p.add(lLastName);
    p.add(jAge);
    p.add(lAge);
    p.add(jDate);
    p.add(lDate);
    p.add(jType);
    p.add(lType);

    Button Submit=new Button("Submit");

    Submit.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        String[] formData = new String[5];
        formData[0] = jFirstName.getText() + ": " + lFirstName.getText();
        formData[1] = jFirstName.getText() + ": " + lLastName.getText();
        formData[2] = jAge.getText() + ": " + lAge.getText();
        formData[3] = jDate.getText() + ": " + lDate.getText();
        formData[4] = jType.getText() + ": " + lType.getText();

        TextArea textArea = new TextArea();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < formData.length; i++)
        {
          sb.append(formData[i]);
          sb.append("\n");
        }
        textArea.setText(sb.toString());

        final Dialog dialog = new Dialog(frm, "Form Data");
        dialog.setModal(true);
        dialog.addWindowListener(new WindowAdapter()
        {
          @Override
          public void windowClosing(WindowEvent e)
          {
            dialog.setVisible(false);
          }
        });
        dialog.add(textArea);
        dialog.pack();
        dialog.setVisible(true);
      }
    });

    p.add(Submit);
    //p1.add(p);
    frm.add(/*p1*/p,BorderLayout.NORTH);
  }
}