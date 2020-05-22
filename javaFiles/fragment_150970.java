binder.addCommitHandler(new CommitHandler() {

    @Override
    public void preCommit(CommitEvent commitEvent) throws CommitException {
        // TODO throw new CommitException() if your validation fails
    }

    @Override
    public void postCommit(CommitEvent commitEvent) throws CommitException {
        // TODO throw new CommitException() if your validation fails
    }
});