// define kie client
    KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(
            "http://docklin:8180/kie-server/services/rest/server",
            "ks-user",      //user must have role "kie-server" assigned
            "ks-user");
    config.setMarshallingFormat(MarshallingFormat.XSTREAM);     

    KieServicesClient client = KieServicesFactory.newKieServicesClient(config);     

    // set container for execution and prepare the call
    String containerId = "fm";
    KieServerCommand call = new CallContainerCommand(containerId, xStreamXml);        
    List<KieServerCommand> cmds = Arrays.asList(call);
    CommandScript script = new CommandScript(cmds);

    ServiceResponsesList reply = client.executeScript(script);        

    for (ServiceResponse<? extends Object> r : reply.getResponses()) {
            System.out.println(r.getResult());

            if (r.getResult() != null) {
                ExecutionResultImpl result = (ExecutionResultImpl) BatchExecutionHelper.newXStreamMarshaller().fromXML((String) r.getResult());
                // getting the same object that was sent but with filled in values
                trans = (Transaction) result.getResults().get("InputTransaction");
                // Objects From insert(fact0) in rule. The problem is that they are staying and multiplying there in Drools, don't know yet how to manage it. ToDo.
                ArrayList<Object> objects = (ArrayList<Object>) result.getResults().get("objects");                 
                System.out.println(objects); 
    }
    else
                System.out.println("Empty result...?");
    }