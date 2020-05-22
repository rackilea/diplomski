dateColumnSortCompareFunc(obj1:Object, obj2:Object) : int {
  // here you translate your object into things that can be evaluated
  // and return 1 if obj1 > obj2, 0 if they are equal, and -1 if obj1 < obj2
  // for example
  var d1:Date = new Date(obj1);
  var d2:Date = new Date(obj2);
  return ( d1.valueOf() > d2.valueOf() ) ? 1 : ( d1.valueOf() < d2.valueOf() ) ? -1 : 0;
}