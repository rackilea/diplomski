public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public List<Person> findAll() {
        return personDao.getAll();
    }

    public setPersonDaoA(PersonDao personDao) {
        this.personDao = personDao;
    }
}