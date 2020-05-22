BeanA beanA = new BeanA();
BeanB beanB = new BeanB();
beanB.setName("Will");
beanA.setBeans(new BeanB[] {new BeanB(), beanB});

ObjectMapper om = new ObjectMapper();
om.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
String json = om.writeValueAsString(beanA);
System.out.println(json); 
// output: {"beans":[{},{"name":"Will"}]}

BeanA deserializedBeanA = om.readValue(json, BeanA.class);
System.out.println(deserializedBeanA); 
// output: BeanA{beans=[BeanB{name='null'}, BeanB{name='Will'}]}