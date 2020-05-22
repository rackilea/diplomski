IOverwriteQuery overwriteQuery = new IOverwriteQuery() {
        public String queryOverwrite(String file) { return ALL; }
};

String baseDir = // location of files to import
ImportOperation importOperation = new ImportOperation(project.getFullPath(),
        new File(baseDir), FileSystemStructureProvider.INSTANCE, overwriteQuery);
importOperation.setCreateContainerStructure(false);
importOperation.run(new NullProgressMonitor());