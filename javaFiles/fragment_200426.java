MessageBuilder messages = new MessageBuilder("my token");
        // prepare event properties
        JSONObject eventProp = new JSONObject();
        eventProp.put("City", "Phnom Penh");
        JSONObject event = messages.event("joe@gribbl.com", "Logged In", eventProp);

        // prepare people properties
        JSONObject peopleProp = new JSONObject();
        peopleProp.put("Full Name", "Cheav Sovannarith");
        JSONObject people = messages.event("joe@gribbl.com", peopleProp);

        ClientDelivery delivery = new ClientDelivery();
        delivery.addMessage(event);
        delivery.addMessage(people);

        MixpanelAPI mixpanel = new MixpanelAPI();
        mixpanel.deliver(delivery);