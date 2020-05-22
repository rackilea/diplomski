DBObject test = container.findOne(f1);
BasicDBList values = (BasicDBList) test.get("value");

for (Object value : values) {
    System.out.println(value);
}