@Override
public void handleMessage(Message message) throws Fault {
    Map<String,List> map = (Map<String, List>)message.get(Message.PROTOCOL_HEADERS);
    message.put(Message.CONTENT_TYPE, "multipart/form-data");
    map.put("content-type", Collections.singletonList("multipart/form-data"));
    message.put(Message.PROTOCOL_HEADERS, map);
}