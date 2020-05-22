public static void main(String[] args) throws Exception
{
    Server server = new Server(8083);
    WebAppContext webapp = new WebAppContext();
    webapp.setContextPath("/");
    webapp.setWar("C:\\Solr\\solr-4.4.0.war");
    webapp.setParentLoaderPriority(true);     // <-- this line
    server.setHandler(webapp);
    System.setProperty("solr.solr.home", "C:\\solr");
    server.start();
    server.join();
}