@Primary
@Bean
@ConfigurationProperties(prefix = "datasource.consumerappointment")
public DataSource consumerAppointmentDataSource() {
    return DataSourceBuilder.create().build();
}