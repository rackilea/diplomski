Model model = null;
FileReader reader = null;
MavenXpp3Reader mavenreader = new MavenXpp3Reader();
try {
    reader = new FileReader(pomfile);
    model = mavenreader.read(reader);
    model.setPomFile(pomfile);
}catch(Exception ex){}
MavenProject project = new MavenProject(model);