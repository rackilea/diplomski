public ActPanel(Contour contour) {
   super(new FlowLayout());

   ...
   // you're missing the following lines:
   this.add(slider);
   this.add(button);