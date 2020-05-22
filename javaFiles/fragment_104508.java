Iterator<Attribute> iterator = element.getAttributes();
while (iterator.hasNext())
{
  Attribute attribute = (Attribute)iterator.next();
  QName name = attribute.getName();
  String value = attribute.getValue();
  System.out.println(name+" + "+value);
}