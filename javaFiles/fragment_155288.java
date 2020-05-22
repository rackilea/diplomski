public void mouseClicked(MouseEvent event)
   {  

       if((event.getButton() == MouseEvent.BUTTON1) && between(event.getX(), x, x + image.getIconWidth()) &&  between(event.getY(), y, y + image.getIconHeight()))
            {
                System.out.println("CAUGHT ONE!");
                catchCount++;
                //move(); should be removed
                imageToDraw=image1;

            }

   }