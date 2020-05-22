@Entity
  @Table(name = "STAFF")
  public class Employee implements Serializable {
     private static final long serialVersionUID = 1L;
     //Besides the above mentioned code
     @Basic(optional = false)
     @NotNull
     @Size(min = 1, max = 4)
     @Column(name = "EMPL_BRAN_SUPER")
     private String keyBranchSupervice;
     @Size(max = 4)
     @Column(name = "EMPL_BRAN_VISIT")
     private String keyBranchVisitor;

     public void setBranchSupervice(Branch branchSupervice) {
        this.keyBranchSupervice = branchSupervice.branchPK.getBrachKey();
        this.branchSupervice = branchSupervice;
     }
  }