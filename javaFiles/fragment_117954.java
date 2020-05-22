public static int secondsAfterMidnight(String time) {
    String[] units = time.split(":");
    int hours = Integer.parseInt(units[0]);
    int minutes = Integer.parseInt(units[1]);
    int seconds = Integer.parseInt(units[2].replaceAll("[^0-9]", ""));
    int totalSeconds = 0;
    if (hours > 12 || minutes > 59 || seconds > 59) {  
        return -1;
    } else if (time.contains("AM") || time.contains("PM")) {
        totalSeconds = (hours * 3600) + (minutes * 60) + (seconds);
    } else if (time.contains("AM") && hours == 12) { 
        totalSeconds = (minutes * 60) + (seconds);
    } else {
        return -1;
    }
    return totalSeconds;
}