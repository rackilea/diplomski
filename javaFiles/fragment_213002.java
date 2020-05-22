int milliseconds = 0;
if ( deltaRemainder > 999999 ) {
     milliseconds = deltaRemainder / 1000000;
     deltaRemainder = deltaRemainder % 1000000;
}

if ( milliseocnds > 0 || deltaRemainder > 0) {
   Thread.sleep(milliseconds, deltaRemainder);
}