@Service
public class RecordService{

   @Autowired
   RecordRepository recordRepository;

  public List<Record> findAll(PageRequest pageRequest){
    Page<Record> recordsPage = recordRepository.findAll(pageRequest);
    return recordsPage.getContent();
  }
}