@Value("#{systemProperties['java.version']}")
private String javaVersionMap;

//Dont know how
//@Value("#{systemProperties.javav.version}")
//private String javaVersionDirect;

@Value("${java.version}")
private String javaVersionProp;