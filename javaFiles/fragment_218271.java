float f = ...;
int16 i;
f = f * 32768 ;
if( f > 32767 ) f = 32767;
if( f < -32768 ) f = -32768;
i = (int16) f;