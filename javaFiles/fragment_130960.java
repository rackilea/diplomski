@RestController
@RequestMapping(TrainController.REQUEST_MAPPING_URL)
public class TrainController {

       public static final String REQUEST_MAPPING_URL = "/trains";

        @Autowired
        private TrainService trainService;

        @RequestMapping(value = "/",headers = { "Accept=application/json" }, method = RequestMethod.POST)
        public TrainDto addTrain(@RequestBody TrainDto trainDto) throws Exception {
            return trainService.addTrain(trainDto);
        }

        @RequestMapping(value = "/",method = RequestMethod.GET)
        public List<TrainDto> getTrains() throws Exception {
            return trainService.getTrains();
        }

        @RequestMapping(value = "/{trainId}", method = RequestMethod.GET)
        public TrainDto getTrain(@PathVariable("trainId") long trainId) throws Exception {
            return trainService.getTrain(trainId);
        }

    }