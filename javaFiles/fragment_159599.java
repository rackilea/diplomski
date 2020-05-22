ConfigureForm form = new ConfigureForm(FormType.submit);
form.setPersistentItems(false);
form.setDeliverPayloads(true);
form.setAccessModel(AccessModel.open);

PubSubManager manager 
      = new PubSubManager(connection, "pubsub.communitivity.com");
Node myNode = manager.createNode("http://jabber.org/protocol/geoloc", form);

StringBuilder body = new StringBuilder(); //ws for readability
body.append("<geoloc xmlns='http://jabber.org/protocol/geoloc' xml:lang='en'>");
body.append("   <country>Italy</country>");
body.append("   <lat>45.44</lat>");
body.append("   <locality>Venice</locality>");
body.append("   <lon>12.33</lon>");
body.append("   <accuracy>20</accuracy>");
body.append("</geoloc>");

SimplePayload payload = new SimplePayload(
                              "geoloc",
                              "http://jabber.org/protocol/geoloc", 
                              body.toString());
String itemId = "zz234";
Item<SimplePayload> item = new Item<SimplePayload>(itemId, payload);

// Required to recieve the events being published
myNode.addItemEventListener(myEventHandler);

// Publish item
myNode.publish(item);