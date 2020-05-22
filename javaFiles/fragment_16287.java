@Entity
@Table(name = "Class1")
public class Class1 {
   @Id
   @Column(name = "INITIAL")
   private String initial;

   @Column(name = "NUMBER")
   private Integer number;  
}


@Entity
@Table(name = "Class2")
public class Class2 {
   @Id
   @Column(name = "STATE")
   private String state;

   @Column(name = "NUMBER")
   private Integer number

   @OneToOne
   @JoinColumn(name = "columnWithClass1id")
   private Class1 class1;
}