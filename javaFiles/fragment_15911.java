Dog dog = new Dog();
  Cat cat = new Cat();

  List<ISpeak> animalsThatTalk = new ArrayList<ISpeak>();

  animalsThatTalk.add(dog);
  animalsThatTalk.add(cat);

  for (ISpeak ispeak : animalsThatTalk)
  {
      System.out.println(ispeak.talk());
  }