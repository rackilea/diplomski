@Service
@Transactional(readOnly = true)
public class OtherService extends OtherInheritedDao<MyModel> {
    public OtherService() {
        //same model as used in MyService
        setClazz(MyModel.class);
    }
}