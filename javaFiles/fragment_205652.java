import java.io.Serializable;
  import javax.persistence.Basic;
  import javax.persistence.Column;
  import javax.persistence.EmbeddedId;
  import javax.persistence.Entity;
  import javax.persistence.FetchType;
  import javax.persistence.JoinColumn;
  import javax.persistence.JoinColumns;
  import javax.persistence.ManyToOne;
  import javax.persistence.OneToOne;
  import javax.persistence.Table;
  import javax.validation.constraints.NotNull;
  import javax.validation.constraints.Size;

  @Entity
  @Table(name = "STAFF")
  public class Employee implements Serializable {
     private static final long serialVersionUID = 1L;
     @EmbeddedId
     protected EmployeePK employeePK;
     @Basic(optional = false)
     @NotNull
     @Size(min = 1, max = 15)
     @Column(name = "EMPL_NAME")
     private String name;

     @JoinColumns({
        @JoinColumn(name = "EMPL_COMP_KEY", referencedColumnName = "BRAN_COMP_KEY", insertable = false, updatable = false),
        @JoinColumn(name = "EMPL_BRAN_KEY", referencedColumnName = "BRAN_KEY", insertable = false, updatable = false)})
     @ManyToOne(optional = false, fetch = FetchType.EAGER)
     private Branch branch;
     @JoinColumns({
        @JoinColumn(name = "EMPL_COMP_KEY", referencedColumnName = "BRAN_COMP_KEY", insertable = false, updatable = false),
        @JoinColumn(name = "EMPL_BRAN_SUPER", referencedColumnName = "BRAN_KEY", insertable = false, updatable = false)})
     @OneToOne(optional = false)
     private Branch branchSupervice;
     @JoinColumns({
        @JoinColumn(name = "EMPL_COMP_KEY", referencedColumnName = "BRAN_COMP_KEY", insertable = false, updatable = false),
        @JoinColumn(name = "EMPL_BRAN_VISIT", referencedColumnName = "BRAN_KEY", insertable = false, updatable = false)})
     @OneToOne
     private Branch branchVisitor;
     //GETTERS, SETTERS, ETC
  }

  import java.io.Serializable;
  import javax.persistence.Basic;
  import javax.persistence.Column;
  import javax.persistence.Embeddable;
  import javax.validation.constraints.NotNull;
  import javax.validation.constraints.Size;

  @Embeddable
  public class EmployeePK implements Serializable {
     @Basic(optional = false)
     @NotNull
     @Size(min = 1, max = 4)
     @Column(name = "EMPL_COMP_KEY")
     private String companyKey;
     @Basic(optional = false)
     @NotNull
     @Size(min = 1, max = 4)
     @Column(name = "EMPL_BRAN_KEY")
     private String branchKey;
     @Basic(optional = false)
     @NotNull
     @Size(min = 1, max = 4)
     @Column(name = "EMPL_KEY")
     private String employeeKey;
     //GETTERS, SETTERS, ETC
  }