public class MyClassImpl implements MyClassWritable, Serializable {

   public class IdImpl implements MyClass.IdWritable, Comparable<IdImpl> {
       private int id1;
       private int id2;
       private String id3;

       private IdImpl() {
          super();
       }

       // SETTERS, getters, compareTo, hashCode, equals and toString.
       // implementing Comparable to use MyClass.Id as indexes into Collections
   }

   private final Id id;
   ...
   private String other;

   public MyClassImpl(int id1, int id2, String id3) {
      this.id = new IdImpl();
   }

   // methods
}

<resultMap id="myClassResultMap" type="MyClass">
   <id property="id.id1" column="ID_COL_1" javaType="java.lang.Integer"/>
   <id property="id.id2" column="ID_COL_2" javaType="java.lang.Integer"/>
   <id property="id.id3" column="ID_COL_3" javaType="java.lang.String"/>
   <result property="other" column="OTHER_COL" />
</resultMap>