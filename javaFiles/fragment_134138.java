@Configuration
public class CustomTransactionAttributeSourceConfig
        extends ProxyTransactionManagementConfiguration {

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        this.enableTx = AnnotationAttributes
                .fromMap(importMetadata.getAnnotationAttributes(
                        EnableCustomTransactionManagement.class.getName(),
                        false));
        Assert.notNull(this.enableTx,
                "@EnableCustomTransactionManagement is not present on importing class "
                        + importMetadata.getClassName());
    }

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    @Override
    public TransactionAttributeSource transactionAttributeSource() {
        return new AnnotationTransactionAttributeSource() {

            private static final long serialVersionUID = 1L;

            @Override
            protected TransactionAttribute findTransactionAttribute(
                    Class<?> clazz) {
                TransactionAttribute transactionAttribute = 
                        super.findTransactionAttribute(clazz);
                if (transactionAttribute != null) {
                    // implement whatever logic to override transaction attributes 
                    // extracted from @Transactional annotation
                    transactionAttribute = new DefaultTransactionAttribute(
                            TransactionAttribute.PROPAGATION_REQUIRED);
                }
                return transactionAttribute;
            }

            @Override
            protected TransactionAttribute findTransactionAttribute(
                    Method method) {
                TransactionAttribute transactionAttribute = 
                        super.findTransactionAttribute(method);
                if (transactionAttribute != null) {
                    // implement whatever logic to override transaction attributes
                    // extracted from @Transactional annotation
                    transactionAttribute = new DefaultTransactionAttribute(
                            TransactionAttribute.PROPAGATION_REQUIRED);
                }
                return transactionAttribute;
            }
        };
    }
}