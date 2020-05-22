Handler h = new Handler(context.getMainLooper());

h.post(new Runnable() {
    @Override
    public void run() {
         txview.append("Text"+message.getFrom()+"\n"+message.getBody()+"\n"); 
    }
});