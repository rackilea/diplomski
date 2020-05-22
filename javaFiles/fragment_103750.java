class HelloWorld {
    static main(args) {
        def server = Server.builder()
                .setHandler(new HttpHandler() {
                      public void handle(final Ev ev){
                          ev.dispatch(this)
                      }
                    }
                }).build()
        server.start()
    }
}