private JSONObject createMesssage(String form, String to, String msg, String time) throws Exception {

       JSONObject jsonMessage= new JSONObject();

            jsonMessage.put("from", from);
            jsonMessage.put("to", to);
            jsonMessage.put("msg", msg);
            jsonMessage.put("time", time);

       return jsonMessage;  

    }

  JSONObject obj = new JSONObject();

  private void addMessage(String channel, JSonObject messsage) throw Exception {
               obj.put(channel, message);
   }

  public void saveMessage(String form, String to, String msg, String time, Striing channel ) {

    try {
      addMessage(chanell,createMessage(form,to,msg,time));

    } catch (Exception ex) {
        logger.log(Level.SEVERE, "Exception: ", ex);
    }
  }