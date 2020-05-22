finished=true;
for (int i = 0; i < balls.length; i++){ 
    if (balls[i].getXPosition() >= 550){  
        finished = finished && true; }
    else{
        finished=false;
        break;
    } 
}