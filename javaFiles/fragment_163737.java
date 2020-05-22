public static void parseCommand(String[] args) {

    String playerName = null;
    List<String> argsLst = Arrays.asList(args);              
    if (argsLst.contains("-g")) {
        argsLst.remove("-g");
        // do your logic for '-g' switch
        // ...
    }
    // now you have only two options:
    // /command arg arg
    // /command arg arg playername
    if (argsLst.size() == 3) {
        playerName = argsLst.remove(2);
    }

    // now we've got:
    // /command arg arg
    // so continue dealing with the two 'arg's
    // ...
}