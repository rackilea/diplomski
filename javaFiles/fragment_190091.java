if (extension.equals("py")) {
    return new PythonParser();
}
else if(extension.equals("java")) {
    return new JavaParser();
}
else ...