int x2;
int y2;

//get direction for x cooord
int direction = (int) (Math.random() * 2);

if(direction == 0)
    x2 = (int) (300 + Math.random() * applet_width);
else
    x2 = ((int) (300 + Math.random() * applet_width)) * -1;


//get direction for the y coord
direction = (int) (Math.random() * 2);

if(direction == 0)
    y2 = (int) (300 + Math.random() * applet_width);
else
    y2 = ((int) (300 + Math.random() * applet_width)) * -1;


//draw the line
page.drawLine(mouse_x-15, mouse_y-5,x2,y2);