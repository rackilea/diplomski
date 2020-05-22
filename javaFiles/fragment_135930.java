package net.mycompany.my.service;

    import javax.ejb.Stateless;
    import javax.ws.rs.GET;
    import javax.ws.rs.Path;

    @Stateless
    @Path("/C1AuthService")
    public class MyIPAuthJaxRsService {
        public MyIPAuthJaxRsService() {
        }

        @GET
        @Path("/test")
        public String test() {
            return "Hello RESTFul 2";
        }

    }