static void PrintStringInt(String s, int n)
{
    System.out.println(s + ", " + n);
}

static void PrintStringString(String s, String s2)
{
    System.out.println(s + ", " + s2);
}

interface MyCall {
    void fn(String value);
}

public static void main(String[] argv)
{
    Vector<MyCall> funcs = new Vector<MyCall>();
    funcs.add(new MyCall() { 
      @Override public void fn(String value) {PrintStringInt(value, 4); }});
    funcs.add(new MyCall() { 
      @Override public void fn(String value) {PrintStringString(value, "bar"); }});
    for(MyCall i : funcs){
        i.fn("foo");
    }
}