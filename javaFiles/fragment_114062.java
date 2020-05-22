public String convertToMyFormat(long ms) {
    String secString, msecString;
    //constructing the sec format:
    int sec = (int) (ms / 1000);
    if(sec < 10)        secString = "0"+sec;
    else if(sec == 0)   secString = "00";
    else                secString = ""+sec;
    //constructing the msec format:
    int msec = (int) ((ms-(sec*1000))/10.0);
    if(msec < 10)       msecString = "0"+msec;
    else if(msec == 0)  msecString = "00";
    else                msecString = ""+msec;

    return secString+":"+msecString;
}