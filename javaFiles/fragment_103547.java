class Actor{
  public void act(){
    System.out.println("I act..");
  }
}

class StuntActor extends Actor {
  public void act(){
    System.out.println("I do fancy stunts..");
  }
}

class VoiceActor extends Actor {
  public void act(){
    System.out.println("I make funny noises..");
  }
}