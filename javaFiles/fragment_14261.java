public class MyPrefixQuery extends BooleanQuery {
    public MyPrefixQuery(Term t){
        add(new PrefixQuery(t), Occur.SHOULD);
        add(new TermQuery(t), Occur.SHOULD);
    }
}