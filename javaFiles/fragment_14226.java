@Entity
@EntityListeners({MyListener.class})
public class MyEntity {
    Date modifiedOn;
    User modifiedBy;
    ...
}