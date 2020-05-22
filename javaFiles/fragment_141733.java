@ManagedBean(name = "bean")
@ViewScoped
public class SopDate implements Serializable {

    public Date currentDate;
    public String format;  

    @PostConstruct
    public void init(){
       SopCurrentDate();
    }

    public void SopCurrentDate(){
       currentDate = new Date(); 
       format = "dd-MM-yyyy";
    }
      // getter and setter
}