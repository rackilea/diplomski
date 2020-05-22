@Entity
public class Foo() {
   @Column(name = "id", unique = true, nullable = false)
   private Long id;

   @JsonIgnore
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_Foo")
   private Foo parent;
}