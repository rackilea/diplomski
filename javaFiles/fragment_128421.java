class UpdateTimeTask extends TimerTask {    

    public void run() {

        String time =  DateUtils.now("hh:mm:ss'T'a");              
        String[]arrValues = time.split("T");
        if(arrValues.length>0) {
            String strValue= arrValues[0];
            String []arrTimeValues = strValue.split(":");  
            String strValue1= arrTimeValues[2];
            setTimertext(strValue1);                   
        }                      
    }

    public void setTimertext(String strValue) {         
        runOnUiThread(new Runnable() {
            public void run() {
                FinalTime=timer_time--;                 
                btnTimer.setText(String.valueOf(FinalTime));    
            }
        });
    }

}