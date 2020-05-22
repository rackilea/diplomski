Configuration configuration = new Configuration()
       .setProperty( "hibernate.connection.driver_class", "org.postgresql.Driver" )
       .setProperty( "hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect")
       [...snip...]
       .addAnnotatedClass( com.myPackage.MyClass.class )
       [...] ;