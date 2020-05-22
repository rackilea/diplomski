public class PetPersonPartitioner implements Partitioner {

  @Autowired
  private PersonDAO personDAO;

  @Override
  public Map<String, ExecutionContext> partition(int gridSize) {

    Map<String, ExecutionContext> queue = new HashMap<String, ExecutionContext>();

    List<Person> personList = this.personDAO.getAllPersons();
    for (Person person : personList) {

      ExecutionContext ec = new ExecutionContext();
      ec.put("person", person);
      ec.put("personId", person.getId());

      queue.put(person.getId(), ec);
    }

  return queue;
  }
}