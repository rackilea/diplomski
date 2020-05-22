public enum LookupElement{

    ELEM_1("A","B","C", 1),
    ELEM_2("C","B","C", 1),
    ELEM_3("B","C","A", 2);

    private final String a;
    private final String b;
    private final String c;
    private final int value;

    LookupElement(String a, String b, String c, int v){
        this.a = a;
        this.b = b;
        this.c = c;        
        this.value = v;
    }

    public static LookupElement getByValue(int v){
        for(LookupElement e : values()){
            if(e.value == v) return e;
        }
        return null;
    }

    public static LookupElement getByParams(String a, String b, String c){
        for(LookupElement e : values()){
            if(e.a.equals(a) && e.b.equals(b) && e.c.equals(c)) return e;
        }
        return null;
    }
}