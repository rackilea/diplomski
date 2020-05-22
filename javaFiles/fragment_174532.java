public static GoogleMerchantDetailsDto convertGoogleMerchantDetails(SqlRow row) {
    Array rawTagArray = (Array) row.get("tags");
    List<String> tags = new ArrayList();
    if (rawTagArray != null) {
        String[] tagArray = Util.toStringArray(rawTagArray);
        tags = Arrays.stream(tagArray).collect(Collectors.toList());
    }
    // ... rest of the method ...
}