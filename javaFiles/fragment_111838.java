public class LevelUpOption {
  private String name;
  public String name() { return name; }

  public LevelUpOption(String name, Action<Creature> invoke){
    this.name = name;
    this.invoke = invoke;
  }

  public readonly Action<Creature> invoke;
}