//image dimension on x
     int image_x = 3;
     //initial placement on x,y
     int x=10,y=10;
     for(int i=0;i<coins.length; i++)
     { 
          //if same image is enough one coin
          g2d.drawImage(coin[7],x,y,this);
          x=x+image_x;
     }