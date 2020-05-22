@Configuration
@ConditionalOnClass(name="weblogic.transaction.UserTransaction")
public class WebLogicTxMgrConfig {

    @Bean
    public JtaTransactionManager txManager() {
        return new WebLogicJtaTransactionManager();
    }

}