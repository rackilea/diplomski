@Component
class TaskHandlerMap {

    private final Map<String, AbstractItemHandler> handlerMap = Maps.newHashMap();

    @Autowired
    TaskHandlerMap(XXXHandler handler) {
        handlerMap.put(Constants.XXX_PATH, handler);
    }

    public AbstractItemHandler get(String key) {
        return handlerMap.get(key);
    }
}