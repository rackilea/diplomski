public static void main(String[] args) {
    List<String> fileToArray = new ArrayList<>();
    fileToArray.add("Event=ThermostatDay,time=12000");
    fileToArray.add("Event=Bell,time=9000,rings=5");
    fileToArray.add("Event=WaterOn,time=6000");
    String pattern=".*rings=(\\d+).*";
    Pattern rinngerPat = Pattern.compile(pattern);
    String xTimesRing;
    for(String line : fileToArray) {
        Matcher xTimeSeeker = rinngerPat.matcher(line);
        if(xTimeSeeker.find()) {
            xTimesRing = xTimeSeeker.group(1);
            int xTimeSeekerInt = Integer.parseInt(xTimesRing);
            System.out.println(xTimeSeekerInt);
        }
    }   
}