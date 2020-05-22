public static void main(String[] args) {
    List<String> dayList = new LinkedList<String>();
    dayList.add("00:00-12:59");
    dayList.add("13:00-20:30");
    dayList.add("18:31-23:59");

    Pattern pattern = Pattern.compile("([0-9]{2}:[0-9]{2})-([0-9]{2}:[0-9]{2})");

    DayCoverage dayCoverage = new DayCoverage();
    for (String day : dayList) {
        Matcher matcher = pattern.matcher(day);
        if (!matcher.matches()) {
            System.err.println("Invalid day entry: " + day);
            return;
        }
        LocalTime start = LocalTime.parse(matcher.group(1));
        LocalTime end = LocalTime.parse(matcher.group(2));

        dayCoverage.addIntervall(start, end);
    }

    if (dayCoverage.isComplete()) {
        System.out.println("Completes Full Day");
    } else {
        System.out.println("Not Completes Full Day");
    }
}