Properties p = new Properties();
InputStream in = this.getClass().getResourceAsStream("c.properties");
p.load(in);

String externalFileName = System.getProperty("app.properties");
InputStream fin = new FileInputStream(new File(externalFileName));
p.load(fin);