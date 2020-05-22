List<Object> genericList = new ArrayList<>();
genericList.add("test");
genericList.add(2);
genericList.add('c');

for (Object object: genericList) {
    // "Put" out object (question 1)    
    System.out.println(object);
    // Check object type (question 2)
    if (object instanceof AnyClass) { 
        //doSomething()
    }else if (object instanceof AnotherClass){
        //doSomethingElse()
    }
}