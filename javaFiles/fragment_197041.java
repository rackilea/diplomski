// First correct
long x = 24L*60L*60L*1000L*1000L;
/* x = `86400000000`; */
// Now truncate
x &= 0xFFFFFFFFL; // again: don't forget the L suffix
/* x = `500654080` */