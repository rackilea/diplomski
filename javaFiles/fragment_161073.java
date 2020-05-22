class CommandRegister{
    Map<String, Command> map = new HashMap<String, Command>();

    public void addCommand(String cmdName, Command c){
        map.put(cmdName, c);
    }


    public Command getCommand(String reqName){
        return map.contains(reqName) ? map.get(reqName) : null;
   }
}