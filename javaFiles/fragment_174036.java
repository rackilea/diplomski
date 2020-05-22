String prop1 = "foo";
  String prop2 = "bar";

  try (OutputStream output = new FileOutputStream("config.properties")) {

      Properties prop = new Properties();

      // set the properties value
      prop.setProperty("prop1", prop1);
      prop.setProperty("prop2", prop2);

      // save properties to project root folder
      prop.store(output, "my app's config file");
  } catch (IOException io) {
      io.printStackTrace();
      // TODO: improve error handling
  }