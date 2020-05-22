Method privateMethod = person.getDeclaredMethod("call");

//making private method accessible using reflection
privateMethod.setAccessible(true);

//calling private method using reflection in java
privateMethod.invoke(privateRyan);