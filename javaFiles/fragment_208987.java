ObjectMapper mapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addSerializer(ResultSet.class, new ResultSetSerializer());
    mapper.registerModule(module);

    rs = session.execute("select * from test.jtest ;");
    String json = mapper.writeValueAsString(rs);
    System.out.println("'" + json + "'");