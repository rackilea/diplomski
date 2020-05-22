private static HashMap<CommandSender, Long> lastExplodeUses = new HashMap<>();

public static HashMap<CommandSender, Long> getLastExplodeUses() {
    return lastExplodeUses;
}

public static void setLastExplodeUse(CommandSender player, long till) {
    lastHelpopSended.put(player, till);
}

public static boolean canExplode(CommandSender player) {
    long timeExploded = lastExplodeUses.get(player) == null ? 0 : lastExplodeUses.get(player);
    if (timeExploded == 0) return true; // if it's 0 - you can execute explode command.
    long timeCurrent = System.currentTimeMillis(); // current time in millis
    if (timeExploded < timeCurrent) { // if the timeExploded is lower than timeCurrent you can execude explode command.
        return true;
    }
    return false; // if not, you cant.
}