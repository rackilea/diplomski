public int getvalueY() throws InterruptedException{
  int locationY = 0;
  for(int i=0; i<20;i++){
      PointerInfo pointer = MouseInfo.getPointerInfo();
      Point point = pointer.getLocation();
      locationY = (int)point.getY();
      Thread.sleep(2000);
  }
   return locationY;
}