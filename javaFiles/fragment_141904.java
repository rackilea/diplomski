//Create border
   MyCustomBorder border = new MyCustomBorder(Color.BLACK, 10, new Point(0, 0), img1, new Point(0, 0), img2);

   //Add border to component called my_jLabel
   my_jLabel.setBorder(border);

   //Add action listeners for dragging sliders (very important)
   border.addListeners(my_jLabel);