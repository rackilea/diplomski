public class TheActionHandler implements ActionListener {

      @Override
      public void actionPerformed(final ActionEvent e) {
           if(e.getSource()==bred)
        {
            mousepanel.setBackground(Color.red);
        }

         else if(e.getSource()==bblue)
        {
            mousepanel.setBackground(Color.blue);
        }

         else if(e.getSource()==bgreen)
        {
            mousepanel.setBackground(Color.green);
        }
      }
  }