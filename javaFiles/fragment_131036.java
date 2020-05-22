//-DcmdParam=helloWorld
@Value("#{systemProperties['cmdParam']}")
private String cmdParamMap;

@Value("#{systemProperties.cmdParam}")
private String cmdParamDirect;

@Value("${cmdParam}")
private String cmdParamProp