class MultiSubjectObserver {
   private List<Observer> observerList = new ArrayList<Observer>();

   public void addSubject(PairOfNumbers numbers1) {
      observerList.add(new InnerObserver(numbers1));
   }

   private class InnerObserver extends Observer {
      public InnerObserver(Subject subject) {
         super(subject);
      }

      @Override
      public void update(Subject subject) {
         System.out.println("From multi-observer: " + subject);
      }
   }    
}