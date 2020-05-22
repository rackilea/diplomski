// Each person in the network
for(Set<String> name : network.keySet()) 
{
      boolean isHipster = false;
      // Get their neighbours
      ArrayList<String> neighbours = network.get(name);
      // Get their favourite animal
      String favAnimal = favouriteAnimals.get(name);
      for(String st : neighbours ) //Neighbours loop
      {
          // Get their neighbours favourite animal
          String neighboursFavAnimal = favouriteAnimals.get(st);
          // Compare
          if(favAnimal.equals(neighboursFavAnimal))
          {
              //is a hipster
              isHipster = true;
              //Stop comparing as doesnt matter anymore
              break;
          }   
      }
      // If isHipster is still false then add the name.
      if(!isHipster)
          animalHispters.add(name)
 }