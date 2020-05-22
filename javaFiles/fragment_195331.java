// call this **first**
if(seconds==0 && minutes==0){
    timer.stop();
}

// call this **second**
if(seconds == 0){
    minutes--;
    seconds = 60;
}