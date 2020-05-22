@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Generic {
   @Id @Column(name="ID")
   private Long id;
   ...
}

@Entity
@Table(name="EXTA")
public class ExtA extends Generic {
   @Column(name="fieldA")
   private Generic fieldA;
}