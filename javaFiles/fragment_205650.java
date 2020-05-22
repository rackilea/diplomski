import java.io.Serializable;
  import java.util.List;
  import javax.persistence.Basic;
  import javax.persistence.CascadeType;
  import javax.persistence.Column;
  import javax.persistence.Entity;
  import javax.persistence.FetchType;
  import javax.persistence.Id;
  import javax.persistence.OneToMany;
  import javax.persistence.Table;
  import javax.validation.constraints.NotNull;
  import javax.validation.constraints.Size;

  @Entity
  @Table(name = "COMPANIES")
  public class Company implements Serializable {
     private static final long serialVersionUID = 1L;
     @Id
     @Basic(optional = false)
     @NotNull
     @Size(min = 1, max = 4)
     @Column(name = "COMP_KEY")
     private String key;
     @Basic(optional = false)
     @NotNull
     @Size(min = 1, max = 100)
     @Column(name = "COMP_DESCRIPTION")
     private String description;
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
     private List<Branch> branches;
     //GETTERS, SETTERS...
  }