Person privateRyan = new Person("John" , "8989736353");
Field privateField = person.getDeclaredField("phone");

//this call allows private fields to be accessed via reflection
privateField.setAccessible(true);

//getting value of private field using reflection
String value = (String) privateField.get(privateRyan);