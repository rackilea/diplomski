SVNRepositoryFactoryImpl.setup(); // ONCE!

String url1 = "svn://host1/path1";
SVNRepository repository1 = SVNRepositoryFactory.create(SVNURL.parseURIDecoded(url1));
String url2 = "svn://host2/path2";
SVNRepository repository2 = SVNRepositoryFactory.create(SVNURL.parseURIDecoded(url2));