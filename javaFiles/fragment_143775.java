@Transactional
public class EntryServiceImpl implements EntryService {
    private EntryDao entryDao;
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Entry> findAllEntries()  {
        return entryDao.findAll();
    }
}