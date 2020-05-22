@Entity
public class CodeR {
   @Id
   private Integer code;
   private String libelle;

   @OneToMany
   @JoinColumn(name="CODE_R_ID")
   Set<CodeL> codeLs = new HashSet<CodeL>():

   // getters, setters
}