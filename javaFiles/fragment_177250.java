PointerByReference pParam1 = new PointerByReference();
ret = DCCAPI.myCFunction( pParam1, p2, p1);

and then i retrieve the string ;
Pointer ptrParam1 = pParam1.getPointer();
String sTemp = ptrParam1.getString(0);