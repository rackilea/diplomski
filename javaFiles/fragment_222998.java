@Override
public void onResponse(String response) {
    JSONObject object = null;
    try {
        object = new JSONObject(response);
    } catch (JSONException e) {
        e.printStackTrace();
    }

    JSONArray jsonarray = null;
    try {
        jsonarray = object.getJSONArray("Table");
    } catch (JSONException e) {
        e.printStackTrace();
    }

    SimpleDateFormatter formatter = new SimpleDateFormatter(); //TODO: update this line with the correct formatter
    List<Event> events = new ArrayList<>();
    for (int i = 0; i < jsonarray.length(); i++) {
        try {
            JSONObject obj = jsonarray.getJSONObject(i);
            String str2 = obj.optString("eventdate");
            String str1 = obj.optString("eventcolor"); 
            Date date = formatter.parse(str2);
            int color = Integer.parseInt(str1); //TODO: update this line with the correct code to parse your color
            Event event = new Event(date, color);
            events.add(event);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    for (Event event : events) {
        EventDecorator eventDecorator = new EventDecorator(calendarView, event.getDate(), event.getColor());
        calendarView.addDecorator(eventDecorator);
    }
}