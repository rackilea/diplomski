@Service
public class Service{

    private Manager alphaManager;
    private Manager bravoManager;
    private Manager charlieManager;

    public Service(Manager alphaManager, Manager bravoManager, Manager charlieManager) {
        this.alphaManager = alphaManager;
        this.bravoManager = bravoManager;
        this.charlieManager= charlieManager;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    private void saveToDbMethod(String data) {
        // code to process data...

        alphaManager.save(entityA);
        bravoManager.save(entityB);
        charlieManager.save(entityC);
    }
}