public class CustomTransactionManagementConfigurationSelector extends
        AdviceModeImportSelector<EnableCustomTransactionManagement> {
    @Override
    protected String[] selectImports(AdviceMode adviceMode) {
        switch (adviceMode) {
        case PROXY:
            return new String[] { 
                AutoProxyRegistrar.class.getName(),
                CustomTransactionAttributeSourceConfig.class.getName()
            };
        case ASPECTJ:
        default:
            return null;
        }
    }
}