try (RevWalk revWalk = new RevWalk(repository)) {
  for (Ref ref : repository.getAllRefs().values()) {
    revWalk.markStart(revWalk.parseCommit(ref.getObjectId()));
  }
  for (RevCommit commit : revWalk) {
    // print commit metadata and diff
  }
}