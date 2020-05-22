JavaGenerator {

    public final void generate(Database db) {
    // .... this deletes 'excess' java files
    log.info("Removing excess files");
    this.empty(this.getStrategy().getFileRoot(),this.scala?".scala":".java", this.files, this.directoriesNotForRemoval);
    this.directoriesNotForRemoval.clear();
    this.files.clear();
    }
}