class MyServiceForChecks extends Service {
      private List<StackTraceElement[]> invocationStackTraces = new ArrayList<>(); 

      public boolean containsDigit(int n, int d) { // its not static anymore
           StackTraceElement [] stackTrace =  getStackTrace();
           invocationStackTraces.add(stackTrace); 
        return super.containsDigit(n,d);
      }

      public List<StackTraceElement[]> getInvocationStackTraces () {
           return this.invocationStackTraces;
      }
 }