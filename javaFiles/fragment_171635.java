public void redFlavour(){
         R.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 if(R.isSelected()){
                 bubPan.setR(1);
                 bubPan.setG(0);
                 bubPan.setB(0);
                 }else if(!R.isSelected()){
                     bubPan.setR(0);
                 }
                 repaint();
             }
         });
     }

     public void greenFlavour(){
         G.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 if(G.isSelected()){
                     bubPan.setR(0);
                     bubPan.setG(1);
                     bubPan.setB(0);
                 }else if(!G.isSelected()){
                     bubPan.setG(0);
                 }
                 repaint();
             }
         });
     }

     public void blueFlavour(){
         B.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 if(B.isSelected()){
                     bubPan.setR(0);
                     bubPan.setG(0);
                     bubPan.setB(1);
                 }else if(!B.isSelected()){
                     bubPan.setB(0);
                 }
                 repaint();
             }
         });
     }