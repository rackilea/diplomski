@javax.ejb.Startup
@javax.ejb.Singleton
public class Lifecycle {


    @javax.annotation.PostConstruct
    public void start() {
        //send mail
    }

    @javax.annotation.PreDestroy
    public void shutdown {
        // do something else :)
    }

}