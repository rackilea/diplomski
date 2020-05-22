Object[][] transformSetTo2dArray(Set < MyClassWhithFourFields > mySet) {
 if (mySet == null) {
  return null;
 }
 Object[][] result = new Object[4][mySet.size()];
 int j = 0;
 // iterate the set:
 for (MyClassWhithFourFields myObject: mySet) {
  myObject[0][j] = myObject.field1;
  myObject[1][j] = myObject.field2;
  myObject[2][j] = myObject.field3;
  myObject[3][j] = myObject.field4;
  j++;
 }
 return result;
}