from("file:fileLocation?idempotent=true&preMove=working")
       .process(new MessageProcessor())
       .choice()
           .when(header("processPassed").isEqualTo(true))
              .to("file:newLocation")
       .otherwise()
           .to("file:fileLocation");