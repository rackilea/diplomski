Map<String,String> propertyList = new HashMap<String,String>();

         propertyList.put("EmailAddress","Email");

         propertyList.put("FirstName","First Name");

         propertyList.put("LastName","Last Name");

   mav.addObject("propertyList ", propertyList);

   if (propertyList.containsKey("LastName")) { // Here you can check the key

           \\Code that needs to fire

 }