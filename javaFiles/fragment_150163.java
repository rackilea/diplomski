Collections.sort(eventList, new Comparator<Event>() {
        @Override
        public int compare(Event e1, Event e2) {

            return e1.startsOn.compareTo(e2.startsOn);
        }
    });