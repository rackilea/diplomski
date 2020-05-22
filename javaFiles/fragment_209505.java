public Person getPersonByEmail(String email){
        Person personByName = (Person) em.createQuery(
        "select p from Persons p where p.personEmail like :email"). 
        setParameter("email", email).getSingleResult();
        return personByName;
}