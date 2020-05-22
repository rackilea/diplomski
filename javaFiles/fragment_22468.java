public class History
{
  // thread-safety issues !!!! 
  // In fact, here you should use a StringBuffer or some locking.
  private StringBuilder historyBuilder = new StringBuilder();

  public void saveEvent(String event)
  {
     historyBuilder.append(event).append('\n');
  }

  public String getHistoryString()
  {
     return historyBuilder.toString();
  }
}