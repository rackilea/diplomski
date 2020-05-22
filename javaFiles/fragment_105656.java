public class Bar {
   Object readingListLock = new Object();

   public void someMethodThatModifiesReading() {
      synchronized(readingListLock) {
          foo.getReadingList().setName("1");
      }
   }

   public void someOtherMethodThatModifiesReading() {
      synchronized(readingListLock) {
          foo.getReadingList().setName("2");
      }
   }

   ...
}