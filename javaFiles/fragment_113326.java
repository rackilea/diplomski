List<Nocturnal> animals = new ArrayList<>();
  animals.add(new Owl());
  animals.add(new Bat());

  for(Nocturnal animal : animals) {
      System.out.println(
           "Name: " + animal.getName() + 
           " Blind: " + animal.isBlind());
  }