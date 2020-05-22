public class MyClassImpl implements MyClassWritable, Serializable {

   public class IdImpl implements MyClass.Id, Comparable<IdImpl> {
       private final int id1;
       private final int id2;
       private final String id3;

       private IdImpl(int id1, int id2, String id3) {
          this.id1 = id1;
          this.id2 = id2;
          this.id3 = id3;
       }

       // getters, compareTo, hashCode, equals and toString.
       // implementing Comparable to use MyClass.Id as indexes into Collections
   }

   private final Id id;
   ...
   private String other;

   public MyClassImpl(int id1, int id2, String id3) {
      this.id = new IdImpl(id1, id2, id3);
   }

   // methods
}