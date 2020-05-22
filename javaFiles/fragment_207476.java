@Service
public class MyEnityService {

    @Transactional
    public Boolean create() {
        int id = 5; // This id is existing in my database.
        Person Person = personRepository.findOne(id);
        // SQL: One SELECT is executed. This is normal AND CACHED FROM YOUR ENTITY MANAGER.

        person.setFirstName("aNewFirstName");

        personRepository.saveAndFlush(person);
        // SQL: ONLY ONE update is executed. NOTHING ELSE.

        return true;
    }
}