enum CanDos {
  TALK,
  WALK,
  SLEEP,
  SIT,
  STARE
}

public interface FooThatCanDo {
  boolean can(CanDos item);
}