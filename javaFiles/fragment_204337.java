private void checkMaxPopularity() throws Exception {
    for (StoredArticle ckeckMax : new HashSet<StoredArticle>(monitorCombination.keySet())) {
        if (ckeckMax.getTimeAndPopularity().containsValue(5)) {
            monitorCombination.remove(ckeckMax);
            ReadXml newReadXml = new ReadXml();
            StoredArticle replaceArticle = getReplaceArticle();
            monitorCombination.put(replaceArticle, newReadXml);
            // System.out.print("TestTestTesttesttest");
        }
    }
}