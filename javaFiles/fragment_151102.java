int i =0;
public void onIrEvent(IREvent arg0) {       
    int oX;
    int oY;

    oX = arg0.getAx()/10;
    oY = arg0.getAy()/10;

/////////////here set the buffer
  if(i<12){
     bufferX += oX;
     bufferY +=oY;
 }
 i++;
}