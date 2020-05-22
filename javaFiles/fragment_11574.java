@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseResult {
    //...
}

@Entity
public class AppleResult extends BaseResult {
    //...
}