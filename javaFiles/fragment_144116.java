private class ConversationTask extends AsyncTask<String, Void, Void> {

    private Handler handler;

    public ConversationTask(){
           handler = new Handler();
    }

    @Override
    protected Void doInBackground(String... params) {
        MessageRequest newMessage = new MessageRequest.Builder().inputText(params[0]).context(context).build();

        GLS_service.message("xxxxxxxxx", newMessage).enqueue(new ServiceCallback<MessageResponse>() {
            @Override
            public void onResponse(MessageResponse response) {
                final String textResponse = response.getText().get(0);
                handler.post(new Runnable() {
                         @Override
                         public void run() {
                               if(reply != null){
                                  reply.setText(textResponse);
                               }
                         }
                });                 
            }
            @Override
            public void onFailure(Exception e) {
            }
        });
        return null;
    }
}