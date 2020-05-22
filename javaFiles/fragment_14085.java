public class FooUtil {

    public static List<AdditionalInfo> packAdditionalInfo(Object instance) throws Exception {
        List<AdditionalInfo> result = new ArrayList<>();
        for (Field field : instance.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            StoreInTable storeInTable = field.getAnnotation(StoreInTable.class);
            if (storeInTable != null) {
                AdditionalInfo info = new AdditionalInfo();
                info.setKey(storeInTable.value());
                info.setValue(field.get(instance).toString());
                result.add(info);
            }
        }
        return result;
    }
}