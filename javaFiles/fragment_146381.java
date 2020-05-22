private static ComboPooledDataSource cpds = new ComboPooledDataSource();
        public static void MakePool()
        {
               try 
               {
                 cpds=new ComboPooledDataSource();
                 cpds.setDriverClass("com.mysql.jdbc.Driver");
                 cpds.setJdbcUrl("jdbc:mysql://localhost:3306/att_db");
                 cpds.setUser("root");
                 cpds.setPassword("dragon");
                 cpds.setMaxPoolSize(MaxPoolSize);
                 cpds.setMinPoolSize(MinPoolSize);
                 cpds.setAcquireIncrement(Accomodation);
             } 
             catch (PropertyVetoException ex) 
             {
                 //handle exception...not important.....
              }

}
public static Connection getConnection()
{
           return cpds.getConnection();
}