public static void main(String[] args)
{
    String level = "Beginning";
    String firstPlaceName = "TheWinner!";
    double firstPlaceTime = 180.234534D;
    double timeGain = 10.2D;
    int numberOfRunners = 10;

    StringBuilder sb = new StringBuilder();
    sb.append("Level %-10s"); //the level
    sb.append("|"); //divider
    sb.append("%-18s"); //name of winner
    sb.append("|"); //divider
    sb.append("%8.3f s "); //winning time
    sb.append("|"); //divider
    sb.append("%8.3f s ahead"); //time gain
    sb.append("|"); //divider
    sb.append("%5d runners"); // # of runners

    System.out.format(sb.toString(),
            level,
            firstPlaceName,
            firstPlaceTime,
            timeGain,
            numberOfRunners);

}