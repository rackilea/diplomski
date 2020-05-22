boolean hitEdge = false;
for ( Alien alien : aliens ) {
  alien.updateAlien();
  hitEdge = hitEdge || alien.edgeDetection();
}
if ( hitEdge ) {
  for ( Alien alien : aliens ) {
    // do your bounced-off-the-edge stuff here
  }
}