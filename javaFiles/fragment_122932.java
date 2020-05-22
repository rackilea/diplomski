for (int i = 0; i < length; i++) {
    JSONObject attribute = jsonArray.getJSONObject(i);
    String eventID = attribute.getString("eventID");
    String eventName = attribute.getString("eventName");
    String eventDesc = attribute.getString("eventDesc");
    String eventDate = attribute.getString("eventDate");

    eventModel.setEventID(eventID);
    eventModel.setEventName(eventName);
    eventModel.setEventDesc(eventDesc);
    eventModel.setEventDate(eventDate);
}