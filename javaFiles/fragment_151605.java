EchoServiceImplService echoService = new EchoServiceImplService();
        HandlerResolver resolver = new HandlerResolver(){

            @Override
            public List<Handler> getHandlerChain(PortInfo portInfo){
                List<Handler> handlers = new ArrayList<Handler>();
                handlers.add(new LogMessageHandler());
                return handlers;
            }
        };
        echoService.setHandlerResolver(resolver);
        EchoService port = echoService.getEchoServiceImplPort();