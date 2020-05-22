public static void main(String[] args) throws Exception {
    System.out.println("------------------------------------------------------------");

    RepositorySystem system = Booter.newRepositorySystem();

    RepositorySystemSession session = Booter.newRepositorySystemSession(system);

    Artifact artifact = new DefaultArtifact("org.apache.maven.plugins:maven-shade-plugin:2.3");

    DependencyFilter classpathFlter = DependencyFilterUtils.classpathFilter(JavaScopes.COMPILE);

    CollectRequest collectRequest = new CollectRequest();
    collectRequest.setRoot(new Dependency(artifact, JavaScopes.COMPILE));
    collectRequest.setRepositories(Booter.newRepositories(system, session));

    DependencyRequest dependencyRequest = new DependencyRequest(collectRequest, classpathFlter);

    List<ArtifactResult> artifactResults =
            system.resolveDependencies(session, dependencyRequest).getArtifactResults();

//        for (ArtifactResult artifactResult : artifactResults) {
//            System.out.println(artifactResult.getArtifact() + " resolved to " + artifactResult.getArtifact().getFile());
//        }

    //use collectDependencies to collect
    CollectResult collectResult = system.collectDependencies(session, collectRequest);
    DependencyNode node = collectResult.getRoot();
    node.accept(new TreeDependencyVisitor(new DependencyVisitor() {
        String indent = "";
        @Override
        public boolean visitEnter(DependencyNode dependencyNode) {
            System.out.println(indent + dependencyNode.getArtifact());
            indent += "    ";
            return true;
        }

        @Override
        public boolean visitLeave(DependencyNode dependencyNode) {
            indent = indent.substring(0, indent.length() - 4);
            return true;
        }
    }));

}