@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {

 @Autowire
 private SendMsgService sendMsgService;

 @MockBean
 private OkHttpClient okHttpClient;

  @Test
  public void testSendMsg(){

 given(this.okHttpClient.newCall(ArgumentMatchers.any())
            .execute()).willReturn(String);

  EventObj event = //event object
 String result = sendMsgService.sendMess(event);

  }
 }