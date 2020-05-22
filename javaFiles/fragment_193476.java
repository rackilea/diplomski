if(tempAngle==0) {
        x = x + 50;
    }

    if(tempAngle==60) {
        y = y + 50;
    }
    if(tempAngle==120) {

        imgWidth = imgWidth-12;
        y = y + 20;
        x = x - 40;
    }
    if(tempAngle==180) {
        imgWidth = imgWidth+12;
        x = x - 50;
    }
    if(tempAngle==240) {
        y = y - 50;
    }
    if(tempAngle==300) {
        y = y - 20;
        x = x + 40;
    }