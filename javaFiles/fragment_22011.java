for (IBundleGroupProvider provider : Platform.getBundleGroupProviders()) {
   for (IBundleGroup feature : provider.getBundleGroups()) {
      final String providerName = feature.getProviderName();
      final String featureId = feature.getIdentifier();
      for (Bundle bundle : feature.getBundles()) {
         ...
      }
   }
}