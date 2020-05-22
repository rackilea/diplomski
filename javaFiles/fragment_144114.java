public class YourTask implements Runnable {

    private Handler handler;
    private TextView textView;

    public YourTask(TextView textView){
          this.textView = textView;
          handler = new Handler();
    }

    @Override
    public void run() {
        MessageRequest newMessage = new MessageRequest.Builder().inputText(params[0]).context(context).build();

        GLS_service.message("xxxxxxxxx", newMessage).enqueue(new ServiceCallback<MessageResponse>() {

            @Override
            public void onResponse(MessageResponse response) {
                final String textResponse = response.getText().get(0);
                handler.post(new Runnable() {
                             @Override
                             public void run() {
                                   if(textView != null){
                                      textView.setText(textResponse);
                                   }
                             }
                });
            }

            @Override
            public void onFailure(Exception e) {
            }
        });    
    }

}