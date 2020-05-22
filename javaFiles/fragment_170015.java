// Local Code Package
@Service
public class UserOperations extends Operations {


    public void onExecute(Object instance){

        /* Different Logic */

        SomeType type = (SomeType) instance;

        if(type.someOtherField == null){
            custom.setOkay(false);
        }
    }


    @Override
    public void onCreate(Object instance){

        /* Create Logic */

        SomeType type = (SomeType) instance;

        if(type.someField == null){
            custom.setOkay(false);
        }
    }
}