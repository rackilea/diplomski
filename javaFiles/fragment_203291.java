public class PlaceTime {
    StringBuilder place = new StringBuilder();
    Queue<String> times = new PriorityBlockingQueue<>();

    public PlaceTime(String placeTime) {

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        for (String i:placeTime.split(" ")) {
            try {
                dateFormat.parse(i);
                //No exception, add as time
                times.add(i);
            } catch (Exception e) {
                //Exception, add as place name
                place.append(i).append(" ");
            }
        }
    }

    public String getPlace() {
        return place.toString();
    }

    public Queue<String> getTimes() {
        return this.times;
    }
}