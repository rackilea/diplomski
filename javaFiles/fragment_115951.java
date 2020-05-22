public void execute() {
    Ant ant = new Ant();
    Project project = new Project();
    project.setProperty("...", ...);
    ant.setProject(project);
    File directory = new File("...");
    ant.setDir(directory);
    ant.setAntfile("build.xml");
    ant.setTarget("all");
    ant.execute();
}