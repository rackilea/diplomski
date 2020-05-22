public void addPlanet(Star star, Planet planet) {
   if(star != null && planet != null) {
      star.getPlanets().add(planet); // assuming the list is always not null
      planet.setStar(star);
   }
}