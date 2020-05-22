MyException exc = new MyException("Here goes my exception.");
exc.setType(exc.getClass().getSimpleName());    
exc.setSeverity("Major");

ObjectMapper mapper = new ObjectMapper();
System.out.println(mapper.writeValueAsString(exc));