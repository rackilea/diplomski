public class Singleton {
      private static Singleton uniqInstance;

      private  List<TestAlarm> mAlarms = new ArrayList<>();

      private Singleton() {
      }

      public static synchronized Singleton getInstance() {
        if (uniqInstance == null) {
          uniqInstance = new Singleton();
        }
        return uniqInstance;
      }

    public void setAllarms(List<TestAlarm> alarms){
        this.mAlarms  = alarms;
   }

public List<TestAlarm> getAllarms(){
  return this.mAlarms;
}

    }