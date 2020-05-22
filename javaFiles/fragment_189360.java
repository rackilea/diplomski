flow = 0;

if ( var == a ) {
   A();
   flow = 1;
}

if ( flow || var == b ) {
   B();
   flow = 1;
}

if ( flow || var == c ) {
   C();
   flow = 1;
}

// and so on