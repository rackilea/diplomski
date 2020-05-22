public void actionPerformed(ActionEvent e) {
              if(p != null){  //becouse after creating Generator object im doing setPanel(this) a short while after :) 
              addItem();     
              p.repaint();
            }
      }