public class Bar {
    Map<Foo, Integer> map;
    public static void main(String[] args) {
        Gson g = new Gson();
        TracingAspect t = new Bar();
        t.map = new HashMap<>();
        t.map.put(new Foo("ff"), 5);
        String j = g.toJson(t);
        System.out.println(j);
    }

}
class Foo {
    String a;
    public Foo (String a) {this.a=a;}
    @Override
    public String toString () {
        return a;
    }
}