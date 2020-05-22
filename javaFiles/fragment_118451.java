@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable{

        @Id @GeneratedValue
        private long id;
        private String intitule;
        private String description;

        @OneToMany(mappedBy = "project" , fetch = FetchType.EAGER)
       @Fetch(value = FetchMode.SUBSELECT)
        @JsonIgnoreProperties("contrats")
        private Collection<Contrat> contrats;

        @ManyToOne
        @JoinColumn(name = "Id_appUser")
        @JsonBackReference
        private AppUser appUser;
 }