protected static String SerializeObject( IBindingFactory lBindingFactory,
        Object request)
{
    String message = null;

    try
    {
      IMarshallingContext lContext = lBindingFactory.
              createMarshallingContext();
      ByteArrayOutputStream lOutputStream = new ByteArrayOutputStream();
      lContext.marshalDocument(request, "UTF-8", null,
              lOutputStream);
      message = new String(lOutputStream.toByteArray(), "UTF-8");
    }
    catch (JiBXException lEx)
    {
      throw new RuntimeException("Problems generating XML, " +
            "underlying problem is " +  lEx.getMessage(), lEx);
    }
    catch (UnsupportedEncodingException lEx)
    {
      throw new RuntimeException("Problems generating XML in specified" +
              "encoding, underlying problem is " + lEx.getMessage(), lEx);
    }
    return message;
}