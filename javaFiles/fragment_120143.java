String valueFromObj2 = null;
String valueFromObj4 = null;
OUTERMOST: for(Object1 object1: objects){
  for(Object2 object2: object1){
    //I get some value from object2
    valueFromObj2 = object2.getSomeValue();
    for(Object3 object3 : object2){
      for(Object4 object4: object3){
        //Finally I get some value from Object4.
        valueFromObj4 = object4.getSomeValue();
        //Compare with valueFromObj2 to decide either to break all the foreach loop
        if( compareTwoVariable(valueFromObj2, valueFromObj4 )) {
          break OUTERMOST;
        }
      }//fourth loop ends here
    }//third loop ends here
  }//second loop ends here
}//first loop ends here