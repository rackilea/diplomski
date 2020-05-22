boolean zIsOk = false;
do{
    try{
      Utwor(x, y, z);
      zIsOk = true;
    }
    catch(IllegalArgumentException e){
      zIsOk = false;
    }
while(!zIsOk)