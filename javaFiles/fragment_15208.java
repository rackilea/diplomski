rule "update time"
   when
        $time : Time(value != currentTime)
    then
        modify($time){
            setValue($time.getCurrentTime());
        };
end

rule "X"
     when
        Time(value = //whatever time)
     then
     // do something
end


public class Time
{
     long value;

     public Time()
     {
          value = getCurrentTime();
     }

     //getter and setter for value

     public long getCurrentTime()
     {
          return System.currentTimeMilliSeconds();
     }

}