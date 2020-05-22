int seconds = 1;
for(int i = 0; i < list.size(); i++){
    setTimer(seconds * i, userName,list.get(i));
}

public void setTimer(int seconds, final String userName, final String content) {
         Timer timer = new Timer();
         timer.schedule(new TimerTask() {
             @Override
             public void run() {
                 setTweet(userName, content);
                 System.out.println("tweet posteado cada 5 segs");
             }
         }, (seconds*1000));       
}