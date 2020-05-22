/**
 * Returns the result of a git log --follow -- < path >
 * @return
 * @throws IOException
 * @throws MissingObjectException
 * @throws GitAPIException
 */
public ArrayList<RevCommit> call() throws IOException, MissingObjectException, GitAPIException {
    ArrayList<RevCommit> commits = new ArrayList<RevCommit>();
    git = new Git(repository);
    RevCommit start = null;
    do {
        Iterable<RevCommit> log = git.log().addPath(path).call();
        for (RevCommit commit : log) {
            if (commits.contains(commit)) {
                start = null;
            } else {
                start = commit;
                commits.add(commit);
            }
        }
        if (start == null) return commits;
    }
    while ((path = getRenamedPath( start)) != null);

    return commits;
}