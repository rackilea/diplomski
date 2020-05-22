public void waitscr(final Stage stage) throws IOException {
    timetask = new TimerTask(){

        @Override
        public void run() {
            if(!timing){
                try{
                    timetask.cancel();
                    setscr(stage);
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            else
                timing = updateTime();
        }
    };
    timer.scheduleAtFixedRate(timetask,1000,1000);
}