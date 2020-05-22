try {
    String[] companyIdArray = new String[1];
    companyIdArray[0] = ""+PortalUtil.getDefaultCompanyId();
    Indexer indexer=IndexerRegistryUtil.getIndexer(JournalArticle.class);
    indexer.reindex(companyIdArray);
} catch (PortalException e) {
    e.printStackTrace();
}