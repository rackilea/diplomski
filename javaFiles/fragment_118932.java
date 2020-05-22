public static class NumberAvailabilityCheck extends Request {
    public String isSuccess = "isSuccess";
    public String result = "result";

    public void sendRequest(String number) {
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                requestResult = new HashMap<String, Object>();
                requestResult.put(isSuccess, true);
                requestResult.put(result, true);
                if (completion != null) {
                    completion.execute(requestResult);
                    requestResult = null;
                }
            }
        }, 5000);
    };
};
public static NumberAvailabilityCheck numberAvailabilityCheck = new NumberAvailabilityCheck();