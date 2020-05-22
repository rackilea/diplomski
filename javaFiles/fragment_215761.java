class Root {
    String batchcomplete;
    Query  query;
}
class Query {
    Map<String, Page> pages;
}
class Page {
    int    pageid;
    int    ns;
    String title;
    String extract;
}