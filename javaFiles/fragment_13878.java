long start_time = System.currentTimeMillis();
 long current_time = System.currentTimeMillis();
 long time_limit = 2000; // In milliseconds: this is the time you want to show the 
                         // object(2 sec)
 while(current_time - start_time) != 2000) {
    ShowObject(); //Here is where you show the object.
    current_time = System.currentTimeMillis();
 }

 HideObject(); //Hide the object after the while loop