// Assuming:
//  your alien class is Alien
//  your list is created like:
ArrayList<Alien> aliens = new ArrayList<Alien>();
//  aliens are added at some point, like:
aliens.add( new Alien() );

// in your loop that wants to drop a missile:
if ( aliens.size() > 0 ) {
  int randomIndex = (int) random( aliens.size() );
  Alien theAlien = aliens.get( randomIndex );
  // drop a missile from `alien`
}