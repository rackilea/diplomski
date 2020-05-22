Field privateStringField = 
   MyClass.class.getDeclaredField("privateString");
privateStringField.setAccessible(true);

String fieldValue = (String) privateStringField.get(privateObject);
System.out.println("fieldValue = " + fieldValue);