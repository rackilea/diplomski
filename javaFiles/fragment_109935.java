@Autowired
    ServletContext context;
............

String relativeWebPath = "/resources/avatars";
String absoluteFilePath = context.getRealPath(relativeWebPath);
File uploadedFile = new File(absoluteFilePath, "your file name");