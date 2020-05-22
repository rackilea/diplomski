// Clone remote repository
CloneCommand cloneCommand = Git.cloneRepository();
cloneCommand.setDirectory(localRepository.toFile());
cloneCommand.setBare(false);
cloneCommand.setURI(remoteRepository.toString());
cloneCommand.setTransportConfigCallback(transportConfigCallback);
Repository repository = cloneCommand.call().getRepository();
ObjectId ref = repository.resolve("your commit or branch");
// Resolve commit hash
RevWalk revWalk = new RevWalk(repository);
RevCommit revCommit = revWalk.parseCommit(ref);
Commit commit = new Commit(revCommit);
TreeWalk tree = new TreeWalk(repository);
tree.addTree(revCommit.getTree());
tree.setRecursive(true);
// Set path filter, to show files on matching path
tree.setFilter(PathFilter.create("path to file"));

try (ObjectReader objectReader = repository.newObjectReader()) {
    while (tree.next()) {
        String fileName = tree.getPathString();
        byte[] fileBytes = objectReader.open(tree.getObjectId(0)).getBytes();        
    }
}
return paths;