DynaProperty[] props = new DynaProperty[]{
        new DynaProperty("firstName", String.class),
        new DynaProperty("lastName",  String.class),
        new DynaProperty("address", java.util.Map.class)

      };
    BasicDynaClass dynaClass = new BasicDynaClass("student", null, props);