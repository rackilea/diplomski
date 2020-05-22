String path = "../webapps/webtest/";
try {
    Runtime.getRuntime().exec(path+"restart.sh");
} catch (IOException e) {
    System.out.println("Exception while running script: "+e);
}