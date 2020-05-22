public class CustomService extends IntentService {

    public CustomService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Request to server
        client.requestToServer()
                .subscribe(response -> {
                                // Successful response
                                doSomething(response);
                            }
                        },
                        error -> {
                                // Error
                                createAlarmInOneHour();
                        });
    }
}