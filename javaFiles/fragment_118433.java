private void runButtonActionPerformed(java.awt.event.ActionEvent evt) { 
    staticLinkTextArea.append("Building Site Map (this can take a while depending on depth) \n");
    crawl.CrawlerInit("http://www.asquithnurseries.co.uk/", "asquithnurseries.co.uk",1);
    new Thread(new Runnable() {
        public void run() {
            crawl.runCrawler();
            crawl.runListURL();
        }
    }).start();
    staticLinkTextArea.append("Building Complete Searching for Static Links \n");

}