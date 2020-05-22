Map<Type, InstanceCreator<?>> instanceCreators
      = new HashMap<Type, InstanceCreator<?>>();

 Excluder excluder = Excluder.DEFAULT;
 FieldNamingStrategy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;

GsonBuilder gb = new GsonBuilder(); 
gb.registerTypeAdapterFactory(new CustomReflectiveTypeAdapterFactory(new ConstructorConstructor(instanceCreators), fieldNamingPolicy, excluder));
gb.registerTypeAdapterFactory(CUSTOM_ENUM_FACTORY);
Gson g = gb.create();