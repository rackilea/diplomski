public interface IFCMService {
@Headers(
        {

                "Content-Type:application/json",
                "Authorization:key=****"
        }
)
@POST("fcm/send")
Call<MyResponse> sendNotification(@Body DataMessage body);
}