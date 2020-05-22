@Entity
@Table(name="MY_OTHER_THING")
@AttributeOverrides({
    @AttributeOverride(name="myData1", column=@Column(name="MY_DATA_1")),
    @AttributeOverride(name="myData2", column=@Column(name="MY_DATA_2"))
})
public class MyOtherThingEntity extends MyThing {

}