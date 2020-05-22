onSensorChanged(){   
  if(state == 1){
    if(duringStep(accel)){
      state = 2;
      ...
      return;
    }
  }   
  else if(state == 2){
    ... 
  }
}