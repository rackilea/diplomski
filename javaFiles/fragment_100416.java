JsonObjectBuilder b = Json.createObjectBuilder();
b.add("foo", "bar");
JsonObject o = b.build();
JsonObject p = b.build();
System.out.println(o.toString()); // {"foo":"bar"}
System.out.println(p.toString()); // {}