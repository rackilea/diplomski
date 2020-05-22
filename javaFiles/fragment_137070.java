public static final Map<String, Supplier<Api>> supplierMap = Map.of(
        "android",  AndroidApi::new,
        "ios",      IosApi::new,
        "windows",  WindowsApi::new
);

public static Api getApi(String type) {
    return supplierMap.get(type.toLowerCase()).get();
}