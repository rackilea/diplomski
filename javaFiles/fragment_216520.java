@Service
public class SendMsgService {

@Autowired
private OkHttpClient okHttpClient;

 public string sendMess(EventObj event) {

ResponseBody body =  RequestBody.create(MediaType.parse("application/json"), payload);
Request request = //built using the Requestbody
//trying to mock a response from execute
Response response = okHttpClient.newCall(request).execute();
//other logic
   }
 }