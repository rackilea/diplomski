public class Main extends Application{

        public Main(){
            doTest();
        }

        private void doTest(){
            long GUID = 0x9cf1bac07b565732L; 
            EventLogger.register(GUID, "conn_factory_logging_test", EventLogger.VIEWER_STRING);
            EventLogger.setMinimumLevel(EventLogger.INFORMATION);

            ConnectionFactory factory = new ConnectionFactory();
            factory.setPreferredTransportTypes(new int[]{ TransportInfo.TRANSPORT_TCP_WIFI, TransportInfo.TRANSPORT_TCP_CELLULAR});
            ConnectionDescriptor cd = factory.getConnection("http://www.google.com");
            HttpConnection httpConnection = (HttpConnection) cd.getConnection();
            try {
                httpConnection.setRequestMethod(HttpConnection.GET);
                int responseCode = httpConnection.getResponseCode();
                String result = "Server Response: " + responseCode;

                EventLogger.logEvent(GUID, result.getBytes(), EventLogger.INFORMATION);
                EventLogger.startEventLogViewer();          
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                try {
                    httpConnection.close();
                } catch (IOException e) {}
            }       
            System.exit(0);
        }

        public static void main(String[] args){
             new Main().enterEventDispatcher();
        }
    }