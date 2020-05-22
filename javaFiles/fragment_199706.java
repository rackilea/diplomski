@Entity
@Table(name = "AB")
public class AB extends AbstractModel {
    //some additional fields if you wish
    private String property2;

    @Column(name = "prop2")
    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
         this.property2 = property2;
    }
   //additional code here
}