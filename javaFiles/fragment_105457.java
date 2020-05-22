Properties props = new Properties();
// if MyClass is in package com.example, look for
// com/example/log4j-config.properties inside the jar
InputStream in = MyClass.class.getResourceAsStream("log4j-config.properties");
try {
  props.load(in);
} finally {
  in.close();
}

// override file location
props.setProperty("log4j.appender.FILE.File", "myfilepath/myfilename.html");

LogManager.resetConfiguration();
PropertyConfigurator.configure(props);