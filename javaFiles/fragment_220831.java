@Service
@Transactional(readOnly = true)
public class MyService extends InheritedDao<MyModel> {
    public MyService() {
        setClazz(MyModel.class);
    }
}