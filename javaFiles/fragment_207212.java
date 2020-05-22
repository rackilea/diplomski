public static String listFilesString(String dirLocation){
    String allPaths = ""; //pretty self explanatory returns full list of files in directory with spaces
    File f = new File(dirLocation);
    if(f.isDirectory()&&f.list().length>0){
        for(File f2 : f.listFiles()){
            if(f2.isDirectory()){
                allPaths = allPaths + f2.toString() + " "; //THIS LINE WAS ADDED
                allPaths = allPaths + listFilesString(f2.toString());
            } else {
                allPaths = allPaths + f2.toString() + " ";
            }
        }
    }
    return allPaths;
}

public static boolean compileOutputToJar(String output, String jarLocation){
    output = output.replace('\\', '/'); //replacements just for uniformity
    String binF = WorkspaceVariables.workspaceDir+output;
    String toCompile = listFilesString(binF).replace('\\', '/');
    try {
        Runtime.getRuntime().exec("jar cvfm " + jarLocation + " " + binF + "manifest.txt " + toCompile); // this line represents the problem
        System.out.println("Compiled Workspace to Jar!");
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}