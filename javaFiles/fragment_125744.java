textField2.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent e2) {
              textField1.setText("");
                textField3.setText("");  
                Double d1,d2,d3;
                d2 = Double.parseDouble(textField2.getText()); // line 101