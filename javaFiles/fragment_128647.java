package work.basil.example;

import javax.sql.DataSource;
import java.util.Objects;

public enum App
{
    INSTANCE;

    // -------|  DataSource  |---------------------------------
    private DataSource dataSource;

    public DataSource provideDataSource ( )
    {
        return this.dataSource;
    }

    public void rememberDataSource ( DataSource dataSource )
    {
        this.dataSource = Objects.requireNonNull( dataSource );
    }


    // -------|  Database  |---------------------------------
    private Database database;

    public Database provideDatabase ( )
    {
        return new Database();
    }
}