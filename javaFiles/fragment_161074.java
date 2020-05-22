class CommandInvoker{
  public CommandInvoker(CommandRegister cR){
    this.cR = cR;
  }

  public void execute(String cmdName){
     Command cmd = cR.get(cmdName);
     cmd.execute(); //if you decided like me to return null if there is no Command with specific name in register you should also check if cmd is not null before calling execute.
  }
}