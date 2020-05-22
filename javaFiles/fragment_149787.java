@Bean
    RouteBuilder restConfiguration(){

        RouteBuilder restConfiguration = new RouteBuilder() {
            @Override
            public void configure() throws Exception{

                restConfiguration().component("servlet")
                        .bindingMode(RestBindingMode.json)
                        .skipBindingOnErrorCode(false) //!!!!!!!!! add this
                        .contextPath(apiContextPath); 
            }
        };
        return restConfiguration;
    }