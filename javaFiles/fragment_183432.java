states.addItemListener(
        new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                 // now there's nothing happen when we select the first item
                if(states.getSelectedIndex()>0){ 
                    System.out.println("YOU CLICK INDEX-"+states.getSelectedIndex());
               }
            }
        }
        );