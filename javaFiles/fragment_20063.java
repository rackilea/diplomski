Thread t2 = new Thread(){
    public void run(){
        clockSet = true;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tfhour.getText()));
        cal.set(Calendar.MINUTE, Integer.parseInt(tfminute.getText()));
        cal.set(Calendar.SECOND, Integer.parseInt(tfsecond.getText()));
        while(true){                    
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);
                int second = cal.get(Calendar.SECOND);                   
               lblKlockan.setText(hour + ":" + minute + ":" + second);
               try {
            sleep(1000);
            cal.add(Calendar.SECOND, 1);
        } catch (InterruptedException e) {
            e.printStackTrace();}
      }
     }
   };