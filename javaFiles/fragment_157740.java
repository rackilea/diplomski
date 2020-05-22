public ArrayList<Object> World= new ArrayList<>();

for (int i =0; i<500; i++)
  World.add(new Object(i));

// Update all objects
for (Object myObject : World) myObject.prop = "Something";