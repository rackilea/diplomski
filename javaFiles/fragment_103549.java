public class Actor{
  public enum Type{ REGULAR, VOICE, STUNT }

  public static Actor Create(Actor.Type type){
    switch(type) {
      case VOICE:
        return new VoiceActor();
      case STUNT:
        return new StuntActor();
      case REGULAR:
      default:
        return new Actor();
    }
  }

  public void act(){
    System.out.println("I act..");
  }
}