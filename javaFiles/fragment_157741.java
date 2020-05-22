public ArrayList<Object> MoversAndShakers = new ArrayList<>();

MoversAndShakers.add(World.get(3));
MoversAndShakers.add(World.get(5));
MoversAndShakers.add(World.get(9));

// Update all MoversAndShakers
for (Object myObject : MoversAndShakers) myObject.prop = "Something";