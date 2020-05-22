System.out.println("Test 1");
CarEqualsTestAgain car1 = new CarEqualsTestAgain("8");
System.out.println("Created car");
map.put(car1, "Red");    
System.out.println("Added car to map");
Object tmp = map.get(car1);
System.out.println("Result of get: " + tmp);