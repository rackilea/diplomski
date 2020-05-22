@RestController public class TrainController {

    @Autowired
    private TrainService trainService;

    @RequestMapping(value = "/trains",headers = { "Accept=application/json" }, method = RequestMethod.POST)
    public TrainDto addTrain(@RequestBody TrainDto trainDto) throws Exception {

        return trainService.addTrain(trainDto);
    }

    @RequestMapping(value = "/trains",method = RequestMethod.GET)
    public List<TrainDto> getTrains() throws Exception {

        return trainService.getTrains();
    }

    @RequestMapping(value = "/trains/{trainId}", method = RequestMethod.GET)
    public TrainDto getTrain(@PathVariable("trainId") long trainId) throws Exception {

        return trainService.getTrain(trainId);
    }

}