Div d = new Div();

File f = new File("test.xml");

Serializer ser = new Persister(new AnnotationStrategy()); /* Don't miss AnnotationStrategy!! */
ser.write(d, f);