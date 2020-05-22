@Override
public InputStream getResourceAsStream(String name)
{
  if (name!=null && name.equals("META-INF/services/javax.xml.bind.JAXBContext"))
  {
    return new ByteArrayInputStream("com.sun.xml.bind.v2.ContextFactory".getBytes());
  }
  return super.getResourceAsStream(name);
}