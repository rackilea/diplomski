//Service Class
@Override
@Transactional
public Person getPersonWithRoles(UUID personId){
    Person person = personDAO.find(personId);

    Hibernate.initialize(person.getRoles());

    return person;
}