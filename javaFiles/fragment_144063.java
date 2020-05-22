public class Testing implements RequestHandler<CloudWatchLogsEvent, String> {


        public String handleRequest(CloudWatchLogsEvent request, Context context){
            context.getLogger().log(request.toString());
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            context.getLogger().log("Invocation started: " + timeStamp);

            context.getLogger().log(request.toString());

            timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            context.getLogger().log("Invocation completed: " + timeStamp);
            return "completed";
        }
}