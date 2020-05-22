StlMeshImporter stlImporter = new StlMeshImporter(); 

try {
    stlImporter.read(this.getClass().getResource("<STLfile>.stl"));
}
catch (ImportException e) {
    e.printStackTrace();
    return;
}