package net.mycompany.my.service;

    import javax.ejb.Stateless;
    import javax.ws.rs.ApplicationPath;
    import javax.ws.rs.core.Application;
    import java.util.HashSet;
    import java.util.Set;

    @Stateless
    @ApplicationPath(value="/C1AuthService")
    public class MyIPAuthJaxRsServiceApplication extends Application {

        private Set singletons = new HashSet();

        public MyIPAuthJaxRsServiceApplication() {
            singletons.add(new MyIPAuthJaxRsService());
        }

    }