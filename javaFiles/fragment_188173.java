List<Bus> sortedBuses = new ArrayList<Bus>();

outerloop:
for (Bus bus : allSeats) {
   for (Bus sorted : sortedBuses)
      if (bus.getTime()==sorted.getTime() && bus.getType == sorted.getType)
        continue outerloop;
   sortedBuses.add(bus);
}