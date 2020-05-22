import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.naming.NamingException;

public class JndiInit{

    @PostConstruct
    public void init() throws IOException, SQLException, NamingException{
        System.out.println("Mastersetup for initializing jndi namespace");
    }

    @PreDestroy
    public void tearDown(){
        System.out.println("Tear down");
    }

}