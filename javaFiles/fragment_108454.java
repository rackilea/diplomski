createContext("/", new HttpHandler(){
    @Override
    void handle(final HttpExchange exchange) throws IOException {
         // use getRequestURI()
    }
});