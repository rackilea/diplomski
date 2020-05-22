//variable of Emmiter.Listener
    Emmiter.Listener quizzoStatus = new Emitter.Listener(){
        @Override public void call(Object... args){
            runOnUiThread(new Runnable(){
                @Override public void run(){
                    Log.e("opponet point", opponentPoints + " " + quizzoStatusResponseDto.getPoints());
                }
            });
        }
    };

    //assigning the listener
    socket.on("quizzoStatus", quizzoStatus);
    . . . .
    @Override protected void onDestroy(){
        super.onDestroy();
        //removing the listener...
        socket.off("quizzoStatus", quizzoStatus);
    }