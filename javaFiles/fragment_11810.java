//somewhere in the code
ActorB.tell(new Request(...));
-----------------------------------------
ActorB:

    public void onReceive(Object msg) throws Exception {
        if (msg instanceof Request) {
            //process the request
            ActorA.tell(new Response(...))
        }
    }
----------------------------------------------------------------
ActorA:

    //ActorA is notified
    public void onReceive(Object msg) throws Exception {
        if (msg instanceof Response) {
            System.out.println("Response: " + msg)
        }
    }