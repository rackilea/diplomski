void onCompletion(MediaPlayer mp){
           mp.stop();
           if (count == titles.length -1) {
               count = 0;
           }
           mp.setDataSource(titles[count]);
           count++;
           mp.prepare(); 
           mp.start();
        }