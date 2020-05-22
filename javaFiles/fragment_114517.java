@Configuration
@Import({AtomikosJtaHsqlDatabaseConfiguration.class, AtomikosJtaTransactionManagerConfiguration.class,
    CommonConfiguration.class, JpaConfiguration.class, MessageBrokerConfiguration.class, ServiceConfiguration.class,
    TransactionTemplateConfiguration.class})
@DependsOn({"brokerService"})
public class GlobalTransactionManagerConfiguration {
}