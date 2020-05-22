public class Test2 
{
    static boolean isPressed = false;

     public static void main(String[] args)
     {
        .....
             btnRectangle.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                isPressed = true;
            }
        });
        .....


        class MousePressListener implements MouseListener
        {
            public void mousePressed(MouseEvent event)
            {
                if(!isPressed){
                     System.out.println("the button is NOT pressed");

                }else{
                    System.out.println("the button is pressed");
                }
               .....
             }
          }


     }

}