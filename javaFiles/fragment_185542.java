/**
 * get Serializer
 * 
 * @return
 */
public Serializer getSerializer() {
    Serializer serializer = null;
    Strategy strategy=null;
    VisitorStrategy vstrategy=null;
    if ((idname != null) && (refname != null)) {
        strategy = new CycleStrategy(idname, refname);
    }
    CommentVisitor cv=new CommentVisitor();
    if (strategy==null) {
        vstrategy=new VisitorStrategy(cv);
    } else {
        vstrategy=new VisitorStrategy(cv,strategy);
    }       
    serializer = new Persister(vstrategy);
    return serializer;
}