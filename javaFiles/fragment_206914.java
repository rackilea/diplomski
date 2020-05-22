import lombok.extern.slf4j.Slf4j;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.triggers.Trigger;
import org.apache.flink.streaming.api.windowing.triggers.TriggerResult;
import org.apache.flink.streaming.api.windowing.windows.GlobalWindow;

@Slf4j
public class JourneyTrigger extends Trigger<SensorEvent, GlobalWindow> {

  private final long allowedLatenessMillis;

  public JourneyTrigger(Time allowedLateness) {
    this.allowedLatenessMillis = allowedLateness.toMilliseconds();
  }

  @Override
  public TriggerResult onElement(SensorEvent element, long timestamp, GlobalWindow window, TriggerContext ctx) throws Exception {

    if (element.isEventEnd()==true) {
      log.info("Timer started with allowedLatenessMillis " + allowedLatenessMillis);
      ctx.registerProcessingTimeTimer(System.currentTimeMillis() + allowedLatenessMillis);
    }

    return TriggerResult.CONTINUE;
  }

  @Override
  public TriggerResult onProcessingTime(long time, GlobalWindow window, TriggerContext ctx) throws Exception {
    log.info("onProcessingTime called at "+System.currentTimeMillis() );
    return TriggerResult.FIRE_AND_PURGE;
  }

  @Override
  public TriggerResult onEventTime(long time, GlobalWindow window, TriggerContext ctx) throws Exception {
    return TriggerResult.CONTINUE;
  }



  @Override
  public void clear(GlobalWindow window, TriggerContext ctx) throws Exception {}
}