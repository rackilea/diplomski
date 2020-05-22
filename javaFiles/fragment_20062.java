Thread t1 = new Thread(){
        public void run(){
           while(!clockSet){
            Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);
                int second = cal.get(Calendar.SECOND);                   
               lblKlockan.setText(hour + ":" + minute + ":" + second);
               try {
              sleep(1000);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }
   };