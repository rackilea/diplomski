public void diplay(){
  for (Dog dog : dogs){
    if (dog != null && dog.getName() != null){
      System.out.println("Name of Dog: " + dog.getName());
    }
  }
}