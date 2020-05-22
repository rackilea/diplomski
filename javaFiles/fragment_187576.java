public boolean executeCommand(String command) {
    if(command.equals("+"))      { add();          return true; }else
    if(command.equals("-"))      { subtrair();     return true; }else
    if(command.equals("*"))      { multiplicar();  return true; }else
    if(command.equals("/"))      { dividir();      return true; }else
        {
            System.out.println("The command does not exist.");
            return false;
        }
}