import java.util.Date;

public interface TimeRange<T,K> extends Comparable<T> {

  public K Builder();

  public static interface TimeRangeBuilder<T> {
    public TimeRangeBuilder<T> startDate(Date startDate);
    public TimeRangeBuilder<T> endDate(Date endDate);
    public T build();
  }

  public Date getStartDate();
  public Date getEndDate();
}