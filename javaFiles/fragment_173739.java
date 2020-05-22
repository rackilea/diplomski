InputStream importMoxyBinding = MyApplication.class
    .getResourceAsStream("/json-binding.xml");

List<InputStream> moxyBindings = new ArrayList<>();
moxyBindings.add(importMoxyBinding);

final MoxyJsonConfig jsonConfig = new MoxyJsonConfig();
jsonConfig.setOxmMedatadataSource(moxyBindings);
ContextResolver<MoxyJsonConfig> jsonConfigResolver = jsonConfig.resolver();
register(jsonConfigResolver);