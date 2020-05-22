Object obj1 = parseObjectFromString("123", Integer.class);
System.out.println("Obj: " + obj1.toString() + "; type: " + obj1.getClass().getSimpleName());
BigDecimal obj2 = parseObjectFromString("123", BigDecimal.class);
System.out.println("Obj: " + obj2.toString() + "; type: " + obj2.getClass().getSimpleName());
Object obj3 = parseObjectFromString("str", String.class);
System.out.println("Obj: " + obj3.toString() + "; type: " + obj3.getClass().getSimpleName());
Object obj4 = parseObjectFromString("yyyy", SimpleDateFormat.class);
System.out.println("Obj: " + obj4.toString() + "; type: " + obj4.getClass().getSimpleName());