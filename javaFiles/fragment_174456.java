Set<String> selectedPlanets = new HashSet<String>();

selectedPlanets.add(planet.getDisplayName());        // Whenever a planet is selected
selectedPlanets.remove(planet.getDisplayName());     // Whenever a planet is removed 

// Prepare a String with all planets        
StringBuilder savedPlanets = new StringBuilder("");
for(String planetName : selectedPlanets ){
    savedPlanets.append(planetName).append(",");
}
// Removing , from the end if any       
if(savedPlanets.toString().endsWith(","))
    finalValue = savedPlanets.substring(0, savedPlanets.length()-1);

// finalValue is what you are looking for