myComponent.addMouseListener(new MouseAdapter() {

     @Override
     public void mouseEntered(MouseEvent mEvt) {
        System.out.println("mouse entered");

        if (mEvt.getModifiers() == MouseEvent.BUTTON1_MASK) {
           System.out.println("Mouse dragging as entered");
        }

     }

  });