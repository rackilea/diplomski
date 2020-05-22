@Entity
@DiscriminatorValue("S")
public class Student extends Person {
   @Basic
   @TableGenerator(name="ID_GEN", table="identifier_table", pkColumnName="seq_name",
        valueColumnName="seq_count", pkColumnValue="student_seq")
   @GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_GEN")
   @Column(name = "studentNumber")
   private Long studentNumber;
}