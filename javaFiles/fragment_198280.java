//Dynamically load an instance of the Person class. You're not importing and you can simply configure the class name as an application property
Object person = Thread.currentThread().getContextClassLoader().loadClass("foo.bar.Person").newInstance(); 
Method theMethod = person.getClass().getMethod("setAge", Integer.class);
theMethod.invoke(person, 55); //set a property

client.invoke("testPerson", person); //invoke the operation.