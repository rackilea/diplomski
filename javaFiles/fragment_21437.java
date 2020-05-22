@Entity
@Table(name="MY_THING")
@AttributeOverride(name="myData", column=@Column(name="MY_DATA"))
public class MyThingEntity extends MyThing {


}