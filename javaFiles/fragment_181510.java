@Autowired
SomeSevice someService;

@RequestMapping(value = "task", method = RequestMethod.GET)
@ResponseBody 
public List<MyEntityDto> taskList(Map<String, Object> model) {
    List<MyEntityDto> dtoList = someService.findALl();
    return dtoList;
  }