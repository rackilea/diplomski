A a = new A();
a.name = "MyExample";

B b = new B();
b.bar = "something";

C c = new C();
c.cr = "C1";
c.ste = new BigInteger("7");

a.b = b;

Map<String, Object> map = new HashMap<>();
map.put("rootC", c);
b.representation = map;

ObjectMapper mapper = new ObjectMapper();
mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
mapper.enable(SerializationFeature.INDENT_OUTPUT);

String json = mapper.writeValueAsString(a);