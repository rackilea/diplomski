package work.basil.example;

import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import org.h2.jdbcx.JdbcDataSource;

public class ApplicationServiceInitListener implements VaadinServiceInitListener
{
    @Override
    public void serviceInit ( ServiceInitEvent serviceInitEvent )
    {
        System.out.println( "DEBUG Running `serviceInit` of " + this.getClass().getCanonicalName() );

        // Database work.
        prepareDataSource();
        App.INSTANCE.provideDatabase().initializeDatabase();
    }

    private void prepareDataSource ( )
    {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL( "jdbc:h2:mem:demo;DB_CLOSE_DELAY=-1" );
        ds.setUser( "scott" );
        ds.setPassword( "tiger" );
        App.INSTANCE.rememberDataSource( ds );
    }
}