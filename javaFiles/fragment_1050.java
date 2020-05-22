private long microsecondTickToPPQTick(long msTick, Sequencer seq){
    long ret = msTick / 1000;
    double rawValue = ret / this.tickSize;

    double valueA  = (rawValue - Math.floor(rawValue)); 
    double valueB = ((Math.floor(rawValue)+1) - rawValue);
    double min = Math.min(valueA, valueB);

    if(min == valueA){
        ret =(long) Math.floor(rawValue);
    }else{
        ret =(long) (Math.floor(rawValue)+1);
    }

    log.info("MidiEvent's timestamp: "+ret);

    return ret;
}