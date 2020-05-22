@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getData(@RequestParam(value = "error", required = false) String error) {
        if (error != null && error.equals("true")) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        } else {
            List<String> list = new ArrayList<>();
            list.add("test");
            return new ResponseEntity<List<String>>(list, HttpStatus.OK);
        }
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleError(HttpServletRequest req, Exception exception) {
        return new ResponseEntity<String>("Exception Message", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}