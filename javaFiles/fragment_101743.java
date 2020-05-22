@Entity
public class Person {
   @Id
   @TableGenerator(name="TABLE_GEN", table="SEQUENCE_TABLE", pkColumnName="SEQ_NAME",
       valueColumnName="SEQ_COUNT", pkColumnValue="PERSON_SEQ")
   @GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GEN")
   private long id;
   ...
}