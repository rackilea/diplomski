// Some test data
Parent p = new Parent();
p.addChild(new Child(true, "a", 1));
p.addChild(new Child(true, "b", 2));
p.addChild(new Child(false, "c", 3)); // "disabled"
p.addChild(new Child(true, "d", 4));
p.addChild(new Child(false, "e", 5)); // "disabled"
p.addChild(new Child(false, "f", 6)); // "disabled"


final File f = new File("test.xml");

Serializer ser = new Persister(new AnnotationStrategy()); // Don't forget 'AnnotationStrategy'!
ser.write(p, f); // Serialize to a file or whatever you need