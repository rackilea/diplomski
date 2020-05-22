public static class MyEvent {

int day, month, year;

    public MyEvent(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return day + "-" + month + "-" + year;
    }
}

public static void main(String[] args) {
    //Setup the list
    List<MyEvent> events = new ArrayList<MyEvent>();
    events.add(new MyEvent(02, 03, 2014));
    events.add(new MyEvent(02, 03, 2014));
    events.add(new MyEvent(02, 03, 2014));
    events.add(new MyEvent(01, 03, 2014));
    events.add(new MyEvent(01, 03, 2014));
    events.add(new MyEvent(28, 02, 2014));
    events.add(new MyEvent(28, 02, 2014));
    events.add(new MyEvent(27, 02, 2014));
    events.add(new MyEvent(26, 02, 2014));
    events.add(new MyEvent(26, 02, 2014));
    events.add(new MyEvent(26, 02, 2014));

            //Extract the lists
    Map<Integer, List<MyEvent>> extractedMap = new ListExtractor<Integer, MyEvent>(events).extract(new Extractor<Integer, MyEvent>() {
        @Override
        public Integer getKey(MyEvent v) {
            return v.day;
        }
    });

    StringBuilder sb = new StringBuilder();

    for (Entry<Integer, List<MyEvent>> entry : extractedMap.entrySet()) {
        sb.append("--> ");

        for (MyEvent event : entry.getValue()) {
            sb.append(event.toString());
            sb.append(", ");

        }
        sb.append("\n");
    }

    System.out.println(sb.toString());
}