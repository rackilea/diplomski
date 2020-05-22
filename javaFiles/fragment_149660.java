Map msg = new HashMap();
msg.put(SFipa.CONTENT, content);
msg.put(SFipa.PERFORMATIVE, SFipa.QUERY_IF);
msg.put(SFipa.CONVERSATION_ID, "someuniqueid");
msg.put(SFipa.RECEIVERS, new IComponentIdentifier[]{receiver});
msg.put(SFipa.SENDER, getComponentIdentifier());
agent.sendMessage(msg, SFipa.FIPA_MESSAGE_TYPE);