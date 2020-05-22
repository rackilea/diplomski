Map<Integer, Passenger> to = new HashMap<>();
for(Passenger p : passengers) {
    to.put(p.toId, p);
}

List<PairedPassengers> paired = new ArrayList<>();

for(Passenger q : passengers) {
    Passenger p = to.get(q.fromId);
    if(p != null) {
        paired.add(new PairedPassengers(p, q));
    }
}