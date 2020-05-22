final File f = new File("test.xml"); // output file

WorldObject wo = new WorldObject(); // the object to serialize

// some testdata ...
List<String> l = new ArrayList<>();
l.add("a");
l.add("b");
wo.getVectorNames().add(l);

l = new ArrayList<>();
l.add("c");
l.add("d");
wo.getVectorNames().add(l);


// create the serializer - dont forget the AnnotationStrategy!
Serializer ser = new Persister(new AnnotationStrategy());
ser.write(wo, f); // serialize it to file