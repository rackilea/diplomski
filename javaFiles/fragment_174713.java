public class TimeElement{ 
    final long time;
    final Object value;
    TimeElement(long time, Object value){
        this.time = time;
        this.value = value;
    }    
    public long getTime(){return time;}
    public Object getValue(){return value;}
}