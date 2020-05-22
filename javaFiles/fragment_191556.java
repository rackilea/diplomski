@Entity
@Indexed
public class B {
   @IndexedEmbedded(includePaths="a.b")
   @ManyToOne
   private A a;
   ......
}