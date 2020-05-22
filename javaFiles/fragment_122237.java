@RestController
@RequestMapping("/api/v1/")
public class TestController {

    @GetMapping("test/all/{date}")
    public List<Test> getAllTestsByBeginDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {


    return testService.getAllTestsByBeginDate(date);
    }
  }