public class D5 { 

private JFrame frame;

.
. // is some part in constrcutor
.
  showButton.addActionListener(new ActionListener(){
        @Override 
         public void actionPerformed(ActionEvent evt){
              frame.add(mypanel(),BorderLayout.PAGE_START);
              frame.validate();
         }
  })
}