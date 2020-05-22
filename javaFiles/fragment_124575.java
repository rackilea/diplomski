//draw the line
        g.drawLine(x1, y1, x2, y2);

        //get center of the line
        int centerX =x1 + ((x2-x1)/2);
        int centerY =y1 + ((y2-y1)/2);

        //get the angle in degrees
        double deg = Math.toDegrees(Math.atan2(centerY - y2, centerX - x2)+ Math.PI);

        //need this in order to flip the text to be more readable within angles 90<deg<270
        if ((deg>90)&&(deg<270)){
            deg += 180;
        }

        double angle = Math.toRadians(deg);

        String text = "My text";
        Font f = new Font("default", Font.BOLD, 12);
        FontMetrics fm = g.getFontMetrics(f);
        //get the length of the text on screen
        int sw =  fm.stringWidth(text);

        g.setFont(f);
        //rotate the text
        g.rotate(angle, centerX, centerY);
        //draw the text to the center of the line
        g.drawString(text, centerX - (sw/2), centerY - 10); 
        //reverse the rotation
        g.rotate(-angle, centerX, centerY);