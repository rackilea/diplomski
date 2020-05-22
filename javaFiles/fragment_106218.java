@Override
public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
    final List<String> completions = new ArrayList<>();
    StringUtil.copyPartialMatches(args[0], Arrays.asList(params), completions);
    //                                     ^^^ change is here

    Collections.sort(completions);
    return completions;
}