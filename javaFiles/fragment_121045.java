abstract class (or interface) Command {
  void execute();
}

public void createCommands() {
  commands.add(new Command(){ 
      @Override
      void execute() {
        something.move();
      }
    });
}