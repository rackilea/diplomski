private int numberOfPendingRequests;

public void MyFunc() {
  ArrayList<String> channels = channelManager.getAllChannelsByRegion("xyz");
  final ArrayList<ChannelSchedule> schedules = new ArrayList<ChannelSchedule>();
  final ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
  numberOfPendingRequests = channels.size();
  for (int i = 0; i < channels.size(); ++i) {
    schedules.add(null);
  }
  for (int i = 0; i < channels.size(); ++i) {
    AsyncInvokeURLTask task = null;
    final int index = i;  // final so it can be used in the onPostExecute.
    try {
      task = new AsyncInvokeURLTask(
        channels.get(i), context, new AsyncInvokeURLTask.OnPostExecuteListener() { 
          @Override public void onPostExecute(String result) {
            try {
              ChannelSchedule schedule = mapper.readValue(result, ChannelSchedule.class);
              Log.v("channel name", schedule.getChannelName());
              Log.v("channel date", schedule.getDate());
              Log.v("channel thumb", schedule.getListOfShows().get(0).getShowThumb());
              Log.v("channel time", schedule.getListOfShows().get(0).getShowTime());
              schedules.set(index, schedule);
              numberOfPendingRequests--;
              if (numberOfPendingRequests == 0) {
                // Everything is received, do stuff here.
              }
            } catch (JsonParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JsonMappingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
          }
       });
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    task.execute();
  }
}