public static void setupPath(String[] paths)
{
    PythonInterpreter interpreter = new PythonInterpreter();

    interpreter.exec("import sys;");
    for (int i = 0; i < paths.length; i++) {
        interpreter.exec(String.format("sys.path.append(\"%s\")", paths[i]));
    }
}