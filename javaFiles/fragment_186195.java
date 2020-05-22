@Service("pruebaService")
public class PruebaServiceImpl implements PruebaService{

    private @Autowired UserLoginDao userLoginDao; // injected by Spring when I create the ApplicationContext in my unit-testing class


    @Override
    @Transactional(readOnly=true) 
    public List<UserLogin> obtenerTodasLasCuentas() {        
        List<UserLogin> result = userLoginDao.findAll();
        return result;
    }
}