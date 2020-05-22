parent_panel.setLayout(new BoxLayout(parent_panel, BoxLayout.PAGE_AXIS));
Box horizontalBox = Box.createHorizontalBox(); 
horizontalBox.add(Box.createHorizontalGlue()); 
horizontalBox.add(child_panel); 
horizontalBox.add(Box.createHorizontalGlue()); 
Box verticalBox = Box.createVerticalBox(); 
verticalBox.add(Box.createVerticalGlue()); 
verticalBox.add(horizontalBox); // one inside the other
verticalBox.add(Box.createVerticalGlue());