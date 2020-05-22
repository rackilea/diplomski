@Component
public class MyInventoryExtensionHandler extends AbstractInventoryServiceExtensionHandler {

    @Resource
    protected InventoryServiceExtensionManager extensionManager;

    @PostConstruct
    public void init() {
         extensionManager.registerHandler(this);
    }

    @Override
    public ExtensionResultStatusType retrieveQuantitiesAvailable(Collection<Sku> skus, Map<String, Object> context, ExtensionResultHolder<Map<Sku, Integer>> result) {
        ...
        ...
        return ExtensionResultStatusType.HANDLED;
    }
}