@RestController
public class UtilityController {

    private static Logger LOGGER = LoggerFactory.getLogger(UtilityController.class);

    @RequestMapping("/test")
    ResponseEntity<Object> getAllCountry() {
        LOGGER.info("Country list fetched");
        return ResponseHandler.generateResponse(HttpStatus.OK, false, "Success", null);
    }

}