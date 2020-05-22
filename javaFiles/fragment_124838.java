@FilterDef(name = "my_filter", parameters = {
     @ParamDef(name = "state", type = "string") 
     })
@Filter(name = "my_filter", condition = "status = :status")
@Entity
public class MyEntity{
  ....
  private MyStatus status;
  ....

}