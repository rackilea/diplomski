private  Boolean isStart=false, isFinished=false;
private Long elapsedTime=0L,seconds=0L,hours=0L,minutes=0L,lastPause=0L,updateTime=0L,startTime=0L,days=0L,limitTime=0L;
class TrackerThread extends Thread{
    public TrackerThread() {
        super();
    }

    @Override
    public void run() {
        super.run();
        try {
            while (isStart && !isInterrupted()){
            if (isStart && startTime != 0) {
                if (elapsedTime != 0 && updateTime == 0)
                    lastPause = elapsedTime;
                updateTime = ((System.currentTimeMillis() - startTime) + lastPause);
                seconds = updateTime / 1000;
                minutes = seconds / 60;
                hours = minutes / 60;

                seconds = seconds % 60;
                minutes = minutes % 60;
                hours = hours % 24;
                elapsedTime = updateTime;
                handler.sendEmptyMessage(1);//its just for run Handler

                if(limitTime!=0 && elapsedTime > limitTime) {
                    interrupt();
                }else
                    sleep(1000);
            }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
Handler handler = new Handler(new Handler.Callback() {
    @Override
    public boolean handleMessage(Message msg) {
            holder.days.setText(String.format("%04d",days));
            holder.hours.setText(String.format("%02d", hours));
            holder.minutes.setText(String.format("%02d", minutes));
            holder.seconds.setText(String.format("%02d", seconds));

        if(limitTime!=0 && elapsedTime>limitTime) {
            isFinished = true;
            holder.stop.setVisibility(View.GONE);
            holder.textFinish.setVisibility(View.VISIBLE);
            holder.limDay.setVisibility(View.GONE);
            holder.limMin.setVisibility(View.GONE);
            holder.limHours.setVisibility(View.GONE);
            holder.textLimit.setVisibility(View.GONE);
            RemindMe.db.execSQL(Util.concat("UPDATE trackers SET isFinish=1, elapsedTime=",limitTime," WHERE _id=",getId()));
        }
        return true;
    }
});