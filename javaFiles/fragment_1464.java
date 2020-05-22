public void updateMyStatus(){

    Session.openActiveSession(MainActivity.this,true,new StatusCallback(){
        @Override
        public void call(Session session, SessionState state, Exception exception){

            if (session.isOpened()){

                Request.executeStatusUpdateRequestAsync(
                        session,
                        "Hello Social Networking Site",
                        new Request.Callback() 
                {
                    @Override
                    public void onCompleted(Response response) 
                    {
                        Toast.makeText(MainActivity.this,"Status updated",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }
    });
}