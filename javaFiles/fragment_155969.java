final Element element = new Element("1", "2");
Class<? extends Element> c = element.getClass();

final Field[] fields = c.getFields();

final List<String> values = Stream.of(fields)
    .map(field -> field.get(element).toString())
    .collect(toList());

System.out.println(values);