@Entity
@Table(name = "parent")
public class Parent {
   @Id
   @GeneratedValue(...)
   private String id;

   @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinColumn(name = "parentId")
   Set<Child> children
}

@Entity
@Table(name = "child")
public class Child {
   @Id
   @GeneratedValue(...)
   private String id;

   @Column(...)
   private Parent parent;

}