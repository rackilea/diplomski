public class RandomNumber {
  ...
  private int right, wrong;
  ...
  private void initialize() {
    ...
    btnGo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Random rand = new Random();
        int ran = rand.nextInt(50) + 1;

        String me = textFieldMe.getText();
        if (ran % 2 == 0 && me.equals("e") || ran % 2 != 0 && me.equals("o")){
          ++right;
        }else if (ran % 2 == 0 && me.equals("o") || ran % 2 != 0 && me.equals("e")){
          ++wrong;
        }

        textFieldCpu.setText("" + ran);
      }
    }
    ...
    btnQuit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        textFieldScore.setText("Correct : " + right + " Wrong: " wrong );
        //will automatically convert ints to String
      }
    }
    ...
  }
  ...
}