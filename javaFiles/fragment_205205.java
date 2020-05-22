public class Main {

    private Server serv;

    public Main(){
        run();
    }

    public void run(){

            Restlet restlet = new Restlet() {
                @Override
                public void handle(Request request, Response response) {
                    response.setEntity("Request will be handled", MediaType.TEXT_PLAIN);
                  if(!request.toString().contains("favicon")){
                      System.out.println("do stuff");

                      response.setOnSent(new Uniform() {

                        @Override
                        public void handle(Request req, Response res) {

                            try {
                                serv.stop();//stop the server
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    });

                  }
                }
            };

            // Avoid conflicts with other Java containers listening on 8080!
            try {
                serv = new Server(Protocol.HTTP, 8182, restlet);

                serv.start();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    public static void main(String[] args){

        new Main();

    }

}