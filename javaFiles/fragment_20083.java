public class Main {

    private static List<AttributeEntity> documentAttributeList;

    static {
        documentAttributeList = new ArrayList<>();
        documentAttributeList.add(new AttributeEntity("key1", "value1"));
        documentAttributeList.add(new AttributeEntity("key2", "value2"));
        documentAttributeList.add(new AttributeEntity("key3", "value3"));
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<AttributeEntity> attributeEntities = main.getAttributeEntities(Arrays.asList("key1", "key2"));
        for (AttributeEntity attributeEntity : attributeEntities) {
            System.out.println(attributeEntity.getKey());
        }
    }

    private List<AttributeEntity> getAttributeEntities(List<String> keys) {
        if(hasInvalidKey(keys)){
            return new ArrayList<>();
        } else {
            return documentAttributeList.stream().filter(attribute -> keys.contains(attribute.getKey())).collect(toList());
        }
    }

    private boolean hasInvalidKey(List<String> keys) {
        List<String> attributeKeys = getAttributeKeys();
        return keys.stream().anyMatch(key -> !attributeKeys.contains(key));
    }

    private List<String> getAttributeKeys() {
        return documentAttributeList.stream().map(attribute -> attribute.getKey()).collect(toList());
    }

}