//OnCreate

  app_preferences =  getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
  Editor editor = pref.edit();

public void startTimer(View view) { 
   SharedPreferences.Editor editor = = app_preferences.edit();
   if(running == false) { 
     startTime = getTime(); displayTime.setText("Zeitstoppung läuft");
     editor.putString("zeitAnzeige",(String)displayTime.getText()); 
     running = true; 
     editor.putBoolean("running",true); editor.putLong("startTimer", startTime);
     startEndButton.setText("End Timer");
     editor.putString("timerButton", (String)startEndButton.getText());
     editor.commit(); 
    } else { 
     endTime = getTime();
     editor.putLong("endTime",endTime); totalTime = endTime - startTime;
     editor.putLong("totalTime",totalTime);
     int hours = (int) ((totalTime / (1000*60*60)) % 24); int minutes = (int) ((totalTime / (1000*60)) % 60);
     int seconds = (int) (totalTime / 1000) % 60;
     displayTime.setText(String.valueOf(hours)+ ":"+String.valueOf(minutes)+":"+ String.valueOf(seconds));
     startEndButton.setText("Start Timer"); editor.putString("timerButton",(String)startEndButton.getText());
     editor.commit();
     running = false; 
    } 
}