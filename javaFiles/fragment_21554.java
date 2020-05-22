@EnableWebSocket
    @Configuration
    public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry 
       webSocketHandlerRegistry) {
    webSocketHandlerRegistry.addHandler(createHandler(), 
    "/handler").addInterceptors(new HttpSessionHandshakeInterceptor() 
      {
        @Override
        public void afterHandshake(ServerHttpRequest request, 
         ServerHttpResponse response, WebSocketHandler wsHandler, 
         @Nullable Exception ex) {

            super.afterHandshake(request, response, wsHandler, ex);

        }

        @Override
        public boolean beforeHandshake(ServerHttpRequest request, 
         ServerHttpResponse response, WebSocketHandler wsHandler, 
          Map<String, Object> attributes) throws Exception {
            boolean b = super.beforeHandshake(request, response, 
         wsHandler, attributes) && 
      ((UsernamePasswordAuthenticationToken) 
    request.getPrincipal()).isAuthenticated();
            return b;
        }
         }).withSockJS();
    }

     @Bean
     public WebSocketHandler createHandler() {

    return new MyHandler();

    }
   }