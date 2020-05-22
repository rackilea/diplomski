Javac javaCompile = (Javac) webServiceProject.createTask("javac");
javaCompile.createCompilerArg().setValue("-Xstdout");
String filePath = basePath + "resources" + File.separator
        + "errorlog.log";
javaCompile.createCompilerArg().setFile(new File(filePath));
javaCompile.setNowarn(true);