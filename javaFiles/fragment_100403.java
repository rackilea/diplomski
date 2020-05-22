Parent p = new Parent();
p.setGroupId("org.codehaus.griffon");
p.setArtifactId("application-master-pom");
p.setVersion("1.0.0");
MavenFacet mavenFacet = getFaceted().getFacet(MavenFacet.class);
Model model = mavenFacet.getModel();
model.setParent(p);
mavenFacet.setModel(model);