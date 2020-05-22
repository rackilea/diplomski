JsonObject o=new JsonObject();
o.addProperty("id", "14");
o.addProperty("email", "xxx@gmail.com");

JsonObject companydetails1 = new JsonObject();
companydetails1.addProperty("name", "abc");
companydetails1.addProperty("address", "milton street");
companydetails1.addProperty("postal code", "cincinnati");

o.add("Company",companydetails1);
System.out.println(o.toString());