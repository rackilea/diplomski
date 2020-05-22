for (String s: System.getProperty("java.library.path").split(";")) {
    String pydName = s + "/mypythonlib.pyd";
    File pydFile = new File(pydName);
    if (pydFile.exists()) {
        System.load(pydName);
        break;
    }
}