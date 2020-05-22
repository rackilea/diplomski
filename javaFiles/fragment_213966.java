@Entity
@Table(name = "contact_master")
public class Contact {

      public enum Gender {
           MALE,FEMALE
      }

      @Column(name = "gender")
      @Enumerated(EnumType.STRING)
      private Gender gender;

      @Column(name = "gender", insertable = false, updatable = false)
      private String genderAsText;

      public Gender getGender() {
         return gender;
      }

      public void setGender(Gender gender) {
          this.gender = gender;
      }
}