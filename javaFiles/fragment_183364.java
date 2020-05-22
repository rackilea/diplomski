monTill4ChckBox.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent arg0) {
            if(monTill4ChckBox.isSelected()){
                mondayCost= mondayCost + 2; 
            }
            else{
                mondayCost= mondayCost - 2;             
                monAftergroup.clearSelection();
            }
            System.err.println("Counter: " + mondayCost);
        }
    });