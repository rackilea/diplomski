public class ChannelCallerLookup {

    Map<String, MessageDeliveryClient> lookupMap;

    public ChannelCallerLookup(Map<String, MessageDeliveryClient> lookupMap) {
        this.lookupMap = lookupMap;
    }

    public Map<String, MessageDeliveryClient> getLookupMap() {
        return lookupMap;
    }

    public MessageDeliveryClient get(String key){
        return lookupMap.get(key);
    }
}