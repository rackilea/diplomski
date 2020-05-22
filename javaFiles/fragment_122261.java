@RestController
@RequestMapping("/request")
public class RequestController {

    @RequestMapping(method = RequestMethod.POST)
    public Response postRequest(@RequestBody Request request) {

        String data = request.getData();

        jmsSender.send(data);

        String key = getKeyFromData(data);
        // waits until MQ sends the data
        String mqResponse = jmsReceiver.get(key);

        if (mqIsValid(mqResponse)) {
            return createValidResponse();
        }
        return createNotValidResponse();
    }
}