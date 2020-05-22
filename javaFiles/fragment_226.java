@Entity
public class Prestataires implements Serializable {

  @Id @GeneratedValue
  private Long id;
  private String nom;
  private String email;
  private String tele;
  private String fax;
  private String rib;
  private String adresse;
  private String taches;
  private String photo;

  @Lob
  @Column(name = "file", columnDefinition="BLOB")
  private byte[] file;

  //-------------------Constructors--------------------

  //-------------------Getters and Setters-------------

}