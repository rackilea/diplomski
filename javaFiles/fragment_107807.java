public class MyRecordImpl{
   @Autowired
  RecordService recordService;

  public void doSomething(){
      int page = 0; int pageSize = 5;
      List<Record> recordList = recordService.findAll(new PageRequest(page, pageSize, new Sort(Sort.Direction.DESC, "recordId")));
     //do other implementations here
   }
}