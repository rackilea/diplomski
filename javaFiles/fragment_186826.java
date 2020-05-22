Person p = new Person("foo", "bar");
p.save();

Logger.debug("Complex calculation: " + p.getNameLength());

p.setFirstName("somethingElse");
p.save();

Logger.debug("Complex calculation: " + p.getNameLength());