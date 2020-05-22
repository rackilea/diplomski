if(downloadFeeds(ftpServer, ftpUsername, ftpPassword, getFtpPathToLocalPathMap())) {
    datasource.load();
    engine.init();
    data.load();
    engine.processX(data);
    data.copyIds()
    foo.addX();
    engine.processY();
    // ...
}