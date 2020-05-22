@Service
public class SomeService(){
  @Autowired 
  TaskRepository taskRepository;

  public List<MyEntityDto> findAll(){
    return assemblyTasks(taskRepository.findAll());//TODO implement method assemblyTasks
  }
}