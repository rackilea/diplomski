String pathLogProps = System.getProperty("java.util.logging.config.file");
Properties properties = new Properties();
try {
     properties.load(new FileInputStream(pathLogProps));
     System.out.println(prop.getProperty("database"));
} catch (IOException ex) {
     ex.printStackTrace();
}