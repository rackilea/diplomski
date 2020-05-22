@Service
@Transactional
public class ApplicationService implements AppService{
@Autowired
private AplicacioDao applicationDao;

public List<Application> findAll(){
    return applicationDao.findAll();
    }

@Override
public List<Application> findAllDatabase() {
    return applicationDao.findAllDataBase();
    }

@Override
public Application findById(int id) {
    return applicationDao.findById(id);
    }

@Override
public void insertOrUpdate(Application app) {
    applicationDao.insertOrUpdate(app);
    }

@Override
public void delete(Application app) {
    applicationDao.delete(app);
    }
}