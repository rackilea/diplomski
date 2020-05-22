ObjectMapper mapper = new ObjectMapper();

Status s1 = mapper.readValue("\"ready\"", Status.class);
Status s2 = mapper.readValue("\"notReadyAtAll\"", Status.class);

System.out.println(s1); // READY
System.out.println(s2); // NOT_READY_AT_ALL