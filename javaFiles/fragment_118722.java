int maxBulletsPerRound = 5; 
   Gun gun = new Gun(0); // fully loaded
   int clip;
   do {
    int numberOfBullets = rand.nextInt(maxBulletsPerRound); 
    gun.fire(numberOfBullets);
    System.out.println("You shot " + numberOfBullets + " bullet(s)."); 
    gun.newAmmoAmount(); //uses method in Gun class?
    clip = gun.getAmmoAmount(); // check how many bullets left
  } while( clip > 0);