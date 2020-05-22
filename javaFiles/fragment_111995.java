List<Ref> call = git.tagList().call();
for (Ref ref : call) {
    System.out.println("Tag: " + ref + " " + ref.getName() + " " + ref.getObjectId().getName());

    // fetch all commits for this tag
    LogCommand log = git.log();

    Ref peeledRef = repository.peel(ref);
    if(peeledRef.getPeeledObjectId() != null) {
        // Annotated tag
        log.add(peeledRef.getPeeledObjectId());
    } else {
        // Lightweight tag
        log.add(ref.getObjectId());
    }
}