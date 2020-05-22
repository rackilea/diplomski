Provider[] providers = Security.getProviders();
for (Provider provider : providers) {
    for (Object entry : provider.keySet()) {
        String name = String.valueOf(entry);
        if (name.startsWith("Cipher")) {
            Log.d("Cipher", "Supports: " + name.substring(7));
        }
    }
}