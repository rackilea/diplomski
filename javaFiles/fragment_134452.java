float[] newerArray = new float[ newarray.length + arraytobecopied.length ];
 for ( int i = 0; i < newarray.length; ++i ) {
     newerArray[i] = newarray[i];
 }
 for ( int i = 0; i < arraytobecopied.length; ++i ) {
     newerArray[ newarray.length + i ] = arraytobecopied[i];
 }
 newarray = newerArray; // Point the reference at the new array