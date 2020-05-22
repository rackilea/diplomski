if(direction == 'R'){
  xInc = 1;
  yInc = 0;
  for(int index= 0; index <= distance;index ++){
    this.setXPos(this.xPos +(xInc));
    this.setYPos(this.yPos +(yInc));
    this.alignAll();
    this.delay(20);  
  }

}