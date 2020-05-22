@Entity
@Table(name="Address")
public class Address {

    ...

   @OneToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="emp_id", 
        insertable=true, updatable=false, 
        nullable=true)
   private Employee  employee ;