ClientConfig config = new ClientConfig();

            Client client = ClientBuilder.newClient();

            WebTarget target = client.target(UriBuilder.fromUri("http://localhost:8088/JerseyRest").build());   

            try{
                UserMessage msg =(UserMessage) target.path("rest").path("insertRecord").request()
                .accept(MediaType.APPLICATION_XML).get(UserMessage.class);

               if(msg.getUserCode() != UserMessage.UserCodes.SUCCESS)
                   System.out.println("Msg: " + msg.getUserMsg());


            }catch(Exception e){
                System.out.println(e);
                return;
            }