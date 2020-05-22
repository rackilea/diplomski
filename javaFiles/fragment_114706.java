JavassistAdapter mdAdapter = new JavassistAdapter();
mdAdapter.includeInvisibleTag = false;

new Reflections(new ConfigurationBuilder()
    ...
    .setMetadataAdapter(mdAdapter)
    ...