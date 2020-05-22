private static final ServiceLoader<MessageBundleProvider> LOADER
    = ServiceLoader.load(MessageBundleProvider.class);

private static final List<MessageBundle> BUNDLES;

static { 
    BUNDLES = new ArrayList<MessageBundle>();
    for (MessageBundleProvider provider : loader) {
         for (MessageBundle bundle : provider.getBundles()) {
             BUNDLES.add(bundle);
         }
    }
}