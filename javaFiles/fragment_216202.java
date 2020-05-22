@Bean
public DataSource dataSource(){
   return DataSourceBuilder.create()
            .url("jdbc:oracle:thin:@localhost:1521:curamdb")
            .driverClassName("oracle.jdbc.OracleDriver")
            .username("springbatch")
            .password("password")
            .build();          
}