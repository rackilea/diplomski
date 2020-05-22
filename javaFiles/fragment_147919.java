public ObjectMapper mMapper;

  ...

  if (mMapper == null)
      mMapper = new ObjectMapper();
  YourClass yourClass = (YourClass) mMapper.readValue(stringJSON, YourClas.class);