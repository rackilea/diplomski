public class BeanUtilsTester {

    public static class Foo{
        private String foo="foo";
        public String getFoo() {return foo;}
        public void setFoo(String foo) {this.foo = foo;}
        private Integer bar=123;
        public Integer getBar() {return bar;}
        public void setBar(Integer bar) {this.bar = bar;}
        private List<String> squoggle=Arrays.asList("abc","def");
        public List<String> getSquoggle() {return squoggle;}
        public void setSquoggle(List<String> squoggle) {this.squoggle = squoggle;}
    }

    public static class Bar{
        private String foo="bar";
        public String getFoo() {return foo;}
        public void setFoo(String foo) {this.foo = foo;}
        private Integer bar=456;
        public Integer getBar() {return bar;}
        public void setBar(Integer bar) {this.bar = bar;}
        private String[] fiddle=new String[]{"abc","def"};
        public String[] getFiddle() {return fiddle;}
        public void setFiddle(String[] fiddle) {this.fiddle = fiddle;}
    }

    public static void main(String[] args) throws Exception{
        Foo foo = new Foo();
        Bar bar = new Bar();
        Map<String,Object> fooProps = BeanUtils.describe(foo);
        Map<String,Object> barProps = BeanUtils.describe(bar);
        fooProps.keySet().retainAll(barProps.keySet());
        BeanUtils.populate(bar, fooProps);
        assertEquals(foo.getFoo(),bar.getFoo());
        assertEquals(foo.getBar(), bar.getBar());
    }

}