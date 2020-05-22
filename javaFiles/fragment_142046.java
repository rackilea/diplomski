Timer timer;

void start() {
  timer = new Timer(1000,new List());
}

class List implements ActionListener {
    private counter = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText(""+counter++);

        if (counter == 10)
          timer.removeActionListener(this);
    }
}