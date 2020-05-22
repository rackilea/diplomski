Properties properties = new Properties();
properties.load(input);
List<Field> fields = new ArrayList<Field>();

for (int i = 1; i < Integer.MAX_VALUE; i++) {
    String type = properties.getProperty("field" + i + ".type");
    if (type == null) break;
    String name = properties.getProperty("field" + i + ".name");
    String age = properties.getProperty("field" + i + ".age");
    fields.add(new Field(type, name, age));
}