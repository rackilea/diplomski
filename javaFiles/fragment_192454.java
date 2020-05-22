@Controller
public class SseController {

    @RequestMapping("/emitter")
    public SseEmitter runEmitter(@RequestParam(value = "string1") String string1,
                                 @RequestParam(value = "string2") String string2)
    {
        SseEmitter sseEmitter = new SseEmitter();
        RequestData requestData = new RequestData();
        requestData.setString1(string1);
        requestData.setString2(string2);
        new Thread(new RunProcess(requestData,sseEmitter)).start();
        return sseEmitter;
    }

    private class RunProcess implements Runnable {
        private RequestData requestData;
        private SseEmitter sseEmitter;

        RunProcess(RequestData requestData, SseEmitter sseEmitter) {
            this.requestData = requestData;
            this.sseEmitter = sseEmitter;
        }

        public void run() {
            try {
                sseEmitter.send(requestData.getString1());
                sseEmitter.send(requestData.getString2());
                sseEmitter.send("A third response from SseEmitter");
                sseEmitter.complete();
            } catch (IOException e) {
                e.printStackTrace();
                sseEmitter.completeWithError(e);
            }
        }
    }

}