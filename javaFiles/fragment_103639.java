// supposing processRecords is defined on MyStatelessRemote1 and process defined on MyStatelessLocal1
@Stateless
@TransationAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class MyStatelessBean1 implements MyStatelessLocal1, MyStatelessRemote1 {
    @EJB
    private MyStatelessLocal1 myBean;

    public void processRecords(List<TransferRecord> objs) {
        // No transactional stuff so no need for a transaction here
        for(Object obj : objs) {
            this.myBean.process(obj);
        }
    }

    @TransationAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void process(TransferRecord transferRecord) {
        // Transactional stuff performed in its own transaction
        // ...
    }
}