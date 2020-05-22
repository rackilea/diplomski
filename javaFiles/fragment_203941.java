// Simple binding
Map<Integer, Class<?>> classResolverMap = new HashMap<Integer, Class<?>>();
classResolverMap.put(33, Product.class);
classResolverMap.put(45, Entity.class);

ObjectMapper mapper = new ObjectMapper();
mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

String json = "{...}";

// Parse type
HeaderType headerType = mapper.readValue(json, HeaderType.class);
// Retrieve class by integer value
Class<?> clazz = classResolverMap.get(headerType.getTypeToClassId());
// Create dynamic type
JavaType type = mapper.getTypeFactory().constructParametricType(HeaderObject.class, clazz);
// Parse object
HeaderObject<?> headerObject = (HeaderObject<?>) mapper.readValue(json, type);
// Get the object
Object result = headerObject.getObj();

System.out.println(result);