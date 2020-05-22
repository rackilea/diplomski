final File f = new File("test.xml"); // Input file

Serializer ser = new Persister();
Product p = ser.read(Product.class, f); // deserialize the class


System.out.println(p); // output - thats why i've implemented the 'toString()' method