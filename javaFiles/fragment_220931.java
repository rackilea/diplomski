//int a = 0, b = 0; // we will loop thorugh a,b instead
for(int a = 0; a < 8; a++){
   for(int b = 0; x < 8; x++){
      //b is for the horizontal axis and a for vertical
      if((a + b) % 2 == 0){
        g.setColor(Color.BLACK);
        g.fillRect(30 + b * 80, 30 + a * 80, 80, 80); //make squares of 80 x 80 pixels
      }     
   }
}