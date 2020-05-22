@Override
    public void onReceive(Context context, Intent intent) {

        Bundle extras = intent.getExtras();

        String message = extras != null ? extras.getString("com.parse.Data")
                : "";

        Log.e("message ", " " + message);

        JSONObject jObject;
        try {
            if (message != null && !message.equals("")) {
                jObject = new JSONObject(message);

                from = jObject.getString("from");
                msg = jObject.getString("title");
                title = jObject.getString("msg");



                GCMMessage gcmMessage = new GCMMessage();
                gcmMessage.setMsg_body(msg);
                gcmMessage.setMsg_title(title);
                gcmMessage.setType(0);
                gcmMessage.setDateTime(time);



                DatabaseUtil.insertMessage(context, gcmMessage);
            }

        }

        catch (JSONException e) {
            e.printStackTrace();
        }

    }

}