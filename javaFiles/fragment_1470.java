@Entity
@Table 
public class Data {

  @Id
  private Integer id;

  @Type(type = "org.hibernate.type.TextType")
  private String data;

  // Before Persist or Update to Database
  @PrePersist
  @PreUpdate
  void beforePersistOrUpdate () {

      // Do encrypt
      if(ProjectProperty.isEncryptionEnabled) {
          this.data = ServiceUtil.commonService.doEncryptString(this.data);
      } 
  }

  // Before Load from Database
  @PostLoad
  void beforeLoad() {

      // Do Decrypt
      if(ProjectProperty.isEncryptionEnabled) {
          this.data = ServiceUtil.commonService.doDecryptString(this.data);
      }
  }
}