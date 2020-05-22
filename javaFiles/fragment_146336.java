class ButtonListener implements ActionListener {
    String name;
    public ButtonListener(String name) {
            this.name = name;
     }
     public void actionPerformed(ActionEvent e){
                System.out.println("Button "+name+"has been pressed.");
     }

  }