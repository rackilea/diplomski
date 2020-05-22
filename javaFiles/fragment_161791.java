SvnOperationFactory svnOperationFactory = new SvnOperationFactory();
try {
    String repo = "https://svn_repo/project/branches/releases/";
    String srcBranch = repo + "Release_10";
    String dstBranch = repo + "Release_11";

    // svnOperationFactory.setAuthenticationManager(null);

    SvnLogMergeInfo op = svnOperationFactory.createLogMergeInfo();
    op.setFindMerged(true); // --show-revs merged
    op.setSource(SvnTarget.fromURL(SVNURL.parseURIEncoded(srcBranch)));
    op.setSingleTarget(SvnTarget.fromURL(SVNURL.parseURIEncoded(dstBranch)));
    op.setReceiver(new ISvnObjectReceiver<SVNLogEntry>() {

        @Override
        public void receive(SvnTarget target, SVNLogEntry logEntry) throws SVNException {
            System.out.println("------\n" + logEntry);
        }

    });
    op.run();
} finally {
    svnOperationFactory.dispose();
}