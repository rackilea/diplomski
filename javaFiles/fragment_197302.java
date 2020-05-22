private String os = System.getProperty("os.name").toLowerCase();

if (os.contains("windows"){
  p = Runtime.getRuntime().exec("your batch file");
  p.waitFor();
} else if (os.contains("mac"){
  p = Runtime.getRuntime().exec("your sh file or dmg");
  p.waitFor();
} else {
  p = Runtime.getRuntime().exec("your .sh file");
  p.waitFor();
}