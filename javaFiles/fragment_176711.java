public static void forceIndexUpdate(IProject project) throws Exception {
    ICProject cProject = CoreModel.getDefault().create(project);
    Job.getJobManager().join(ResourcesPlugin.FAMILY_AUTO_REFRESH, null);
    CCorePlugin.getIndexManager().reindex(cProject);
    CCorePlugin.getIndexManager().joinIndexer(IIndexManager.FOREVER, new NullProgressMonitor() );
    assertTrue(CCorePlugin.getIndexManager().isIndexerIdle() );
    assertFalse(CCorePlugin.getIndexManager().isIndexerSetupPostponed(cProject));
}