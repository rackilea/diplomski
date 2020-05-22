public int addOneMinute(){
    minutes++;
    checkMinutes();
}

private void checkMinutes(){
    if (minutes >= 60)
    {
        hours++;
        minutes = minutes - 60; 
    }
}

//Having the private check method makes it simple to expand functionality in the future like so
public int addFiveMinutes(){
    minutes = minutes + 5;
    checkMinutes();
}