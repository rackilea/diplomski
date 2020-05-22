ObjectMapper mapper = new ObjectMapper();
    StdSerializerProvider provider = new StdSerializerProvider();
    provider.setKeySerializer(new KeySerializer(A.class));
    mapper.setSerializerProvider(provider);

    StringWriter out = new StringWriter();
    mapper.writeValue(out, c);
    String json = out.toString();
    System.out.println("JSON= "+json);

    C c2 = mapper.readValue(json, C.class);
    System.out.print("C2= ");
    StringWriter outC2 = new StringWriter();
    mapper.writeValue(outC2, c2);
    System.out.println(outC2.toString());