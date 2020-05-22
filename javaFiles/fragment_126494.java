String json = "{\"id\":\"12345787654323468\",\"roles\":[{\"name\":\"admin\",\"permissions\":[\"can publish\",\"can reject\"]},{\"name\":\"moderator\",\"permissions\":[\"can publish\",\"can reject\"]}]}";

ObjectMapper mapper = new ObjectMapper();
Channel channel = mapper.readValue(json, Channel.class);

System.out.println("Roles :"+channel.getRoles());