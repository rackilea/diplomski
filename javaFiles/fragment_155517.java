class ST {
    List stopwordslist=new List("Stopwords");

    …

class List {
    ST st = new ST();

    public List(String name) {
         ListName=name;
         firstNode=null;
    }