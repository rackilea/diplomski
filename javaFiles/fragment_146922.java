String aspectFileName = "src/main/java/pckg/AspectName.aj";
String jreLibPath = "c:/Program Files/Java/jdk1.8.0_40/jre/lib";
String outputJar = "weavedjre.jar";

List<String> jars = new ArrayList<>();

File dir = new File(jreLibPath);
File[] files = dir.listFiles();
for (File file : files) {
    if (file.isFile() && file.getName().endsWith(".jar")
            && !file.getName().endsWith("jfxswt.jar")) {
        jars.add(file.getAbsolutePath());
    }
}

List<String> ajcArgs = new ArrayList<>(Arrays.asList("-showWeaveInfo"));
for (String jar : jars) {
    ajcArgs.add("-inpath");
    ajcArgs.add(jar);
}
ajcArgs.add(aspectFileName);
ajcArgs.add("-outjar");
ajcArgs.add(outputJar);

org.aspectj.tools.ajc.Main.main(ajcArgs.toArray(new String[] {}));