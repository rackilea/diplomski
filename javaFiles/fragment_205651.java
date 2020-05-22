import java.io.Serializable;
  import java.util.List;
  import javax.persistence.Basic;
  import javax.persistence.CascadeType;
  import javax.persistence.Column;
  import javax.persistence.EmbeddedId;
  import javax.persistence.Entity;
  import javax.persistence.FetchType;
  import javax.persistence.JoinColumn;
  import javax.persistence.ManyToOne;
  import javax.persistence.OneToMany;
  import javax.persistence.Table;
  import javax.validation.constraints.NotNull;
  import javax.validation.constraints.Size;

  @Entity
  @Table(name = "BRANCHES")
  public class Branch implements Serializable {
     private static final long serialVersionUID = 1L;
     @EmbeddedId
     protected BranchPK branchPK;
     @Basic(optional = false)
     @NotNull
     @Size(min = 1, max = 100)
     @Column(name = "BRAN_DESCRIPTION")
     private String description;
     @JoinColumn(name = "BRAN_COMP_KEY", referencedColumnName = "COMP_KEY")
     @ManyToOne(optional = false, fetch = FetchType.LAZY)
     private Company company;
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "branch", fetch = FetchType.LAZY)
     private List<Employee> staff;
     //GETTERS, SETTERS, ETC
  }

  import java.io.Serializable;
  import javax.persistence.Basic;
  import javax.persistence.Column;
  import javax.persistence.Embeddable;
  import javax.validation.constraints.NotNull;
  import javax.validation.constraints.Size;

  @Embeddable
  public class BranchPK implements Serializable {
     @Basic(optional = false)
     @NotNull
     @Size(min = 1, max = 4)
     @Column(name = "BRAN_COMP_KEY")
     private String companyKey;
     @Basic(optional = false)
     @NotNull
     @Size(min = 1, max = 4)
     @Column(name = "BRAN_KEY")
     private String brachKey;
     //GETTERS, SETTERS, ETC
  }