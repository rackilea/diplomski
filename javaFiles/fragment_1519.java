@Entity
@Table(name = "skill")
public class Skill {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToMany(mappedBy = "skillList")
   @JsonBackReference
   private List<Craftsman> craftmanList;
}