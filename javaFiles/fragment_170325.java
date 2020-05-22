public class HmsCalculator
{
  private final Calendar c = Calendar.getInstance();

  public Hms toHms(long t) { return toHms(t, new Hms()); }
  public Hms toHms(long t, Hms hms) {
    c.setTimeInMillis(t*1000);
    return hms.init(c);
  }
  public static class Hms {
    public int h, m, s;
    private Hms init(Calendar c) {
      h = c.get(HOUR_OF_DAY); m = c.get(MINUTE); s = c.get(SECOND);
      return this;
    }
    public String toString() { return String.format("%02d:%02d:%02d",h,m,s); }
  }

  public static void main(String[] args) {
    System.out.println(new HmsCalculator().toHms(
       System.currentTimeMillis()/1000));
  }
}