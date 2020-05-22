int frame_count = 0; 
boolean secondDelay(int aSecond){

    boolean signal = frame_count==0;

    if ( frame_count >= 60*aSecond ) {
        frame_count = 0;
    } else { 
        frame_count ++;
    }
    return signal;
}