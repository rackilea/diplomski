try {

    String cmd = "javac";
    // OR String cmd = "cmd /c javac";
    // OR String cmd = "java -cp myjar com.my.sample";
    Process p = new ProcessBuilder(cmd).inheritIO().start();
    p.waitFor();
} catch(Exception e){
    e.printStackTrace();
}