String runningDir = Simulate.class.getProtectionDomain().getCodeSource().getLocation().getPath();
String jarPointer = "py";
String joinedPath = new File(runningDir, jarPointer).toString();

String pythonSrcPath = "/Users/smcho/code/PycharmProjects/aggregator/src";
JythonObjectFactory.setupPath(new String[]{joinedPath, "src/py"});