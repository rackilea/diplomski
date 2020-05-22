public class ApplicationContext {

    private PersonService personService;
    private PersonDao personDao ;

    public PersonService getPersonService() {
        if (personService == null) {
            personService= new PersonServiceImpl();
            personService.setPersonDao(getPersonDao());
        }
        return personService;
    }

    public PersonDao getPersonDao() {
        if (personDao == null) {
            personDao = new PersonDaoIml();
        }
        return personDao ;
    }
}