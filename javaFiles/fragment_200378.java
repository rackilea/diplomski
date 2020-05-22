public int howManyWagons(Train train){

  boolean end = false;
  int count = 1;

  while(!end){ 

    //save the state of the first wagon
     boolean isFirstWgonLightOn = train.isLightOnInCurrentWagon();

    //light off in the first wagon
    if(train.isLightOnInCurrentWagon()){
      train.switchLight();
    }

    //go n forward
    goFoward(train,count);

    if(train.isLightOnInCurrentWagon()){
      goBack(train,count);
      count++;
    }else{

       train.switchLight();
       goBack(train,count);

       if(train.isLightOnInCurrentWagon()){
         end=true;
       }else{

         //we need to reset the ligt state
         goFoward(train,count);
         train.switchLight();
         goBack(train,count);
         count++;

       }
    }

    //we need to reset to the initial state
    if(isFirstWgonLightOn != train.isLightOnInCurrentWagon()){
     train.switchLight();
    }

  } 
   return count;

}