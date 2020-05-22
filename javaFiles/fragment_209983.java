/**
 * Take first value of a String [] as an Integer, and return null if not Ok
 * @param args a String[] that could come from main
 * @return integer value of args[0] or null
 */
private static Integer getArgs0(String[] args) {
    Integer bonus = null;
    if (args.length > 0) { // special case no args
        try {
            bonus = Integer.parseInt(args[0]);
        }
        catch(NumberFormatException e) {}
    }
    return bonus;
}

/**
 * Convert a null Integer to 0 - else leave it untouched
 * @param bonus input Integer
 * @return 0 if bonus is null else bonus
 */
private static int zeroIfNull(Integer bonus) {
    return (bonus == null) ? 0 : bonus;
}