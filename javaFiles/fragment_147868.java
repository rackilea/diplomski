class Venue {
    PriorityQueue<Event> pq = new PriorityQueue<Event>(Comparator.comparing(Event::getTime));

    public static void main(String[] args) {
        Venue v = new Venue();
        v.addEvents();
        v.display(v.pq);
    }

    private void addEvents() {
        pq.add(new Event("stand up", 90, 200));
        pq.add(new Event("rock concert", 120, 150));
        pq.add(new Event("theatre play", 60, 120));
        pq.add(new Event("street performance", 70, 80));
        pq.add(new Event("movie", 100, 55));
    }

    private void display(PriorityQueue<Event> e) {
        while (!e.isEmpty()) {
            System.out.println(e.remove());
        }
    }
}