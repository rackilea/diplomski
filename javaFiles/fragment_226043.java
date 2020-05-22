public class DatabaseBasedMailSender extends JavaMailSenderImpl{

    public DatabaseBasedMailSender(){
        // connect to database
        // obtain properties

        setHost(...)
        setProtocol(...)
        ...

    }


}

<bean id="mailSender" class="my.project.DatabaseBasedMailSender"/>