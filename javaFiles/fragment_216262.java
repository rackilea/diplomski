// registration using Class.forName service
Driver)Class.forName("solid.jdbc.SolidDriver")

// a workaround to a bug in some JDK1.1 implementations
Driver d = (Driver)Class.forName("solid.jdbc.SolidDriver").newInstance();

// Registration using system properties variable also
Properties p = System.getProperties();
p.put("jdbc.drivers", "solid.jdbc.SolidDriver");
System.setProperties(p);