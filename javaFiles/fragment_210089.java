public void actionPerformed(ActionEvent e) {
       JMenuItem clickedMenu = (JMenuItem) e.getSource();
       if (clickedMenu.getText().equals("Square")) {
           MyShape aSquare = new ASquare();
           myControlPanel.setShape(aSquare);
       } else if (clickedMenu.getText().equals("Circle")) {
           MyShape aCircle = new ACircle();
           myControlPanel.setShape(aCircle);             
       } else if (clickedMenu.getText().equals("Triangle")) {                 
           MyShape aTriangle = new MyShape();  
           myControlPanel.setShape(aTriangle);           
       }         
    }