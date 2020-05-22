class MultiSubjectObserver {
   private static final String FORMAT_STRING = "MultiSubjectObserver activated with numbers: %.1f, %.1f%n";
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
         System.out.printf(FORMAT_STRING, ((PairOfNumbers)subject).getNumber1(),  ((PairOfNumbers)subject).getNumber1());
      }
   }
}