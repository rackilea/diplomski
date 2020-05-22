ObjectMapper mapper = new ObjectMapper();

StudentSummary summary = new StudentSummary();
String test = mapper.writeValueAsString(summary);
System.out.println(test);
System.out.print("DONE");