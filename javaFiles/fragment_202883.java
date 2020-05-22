@Service
public class PersonBanService {
  @Cacheable
  @Transactional(readOnly = true)
  public List<Integer> getBanList() {
    return personBanRepository.findAll();
  }
}

@Service
public class PersonDomainService {
  @Transactional(readOnly = true)
  public List<Person> getPersons() {
    List<Integer> banList = personBanService.getBanList();
    List<PersonEntity> people = personRepository.findAll();
    return people.stream()
      .map( p -> new Person( p, banList.contains( p.getId() ) ) )
      .collect( Collectors.toList() );
  }
}