class T {
    private String field1;

    T(String s) {
        this.field1 = s;
    }  
} 

class A extends T {
    private String field2;

    A(String s1, String s2) {
        super(s1);
        this.field2 = s2;
    } 
}

class B extends T {
    private String field3;
    private String field4;

    A(String s1, String s2, String s3) {
        super(s1);
        this.field3 = s2;
        this.field4 = s3;
    }  
}

@RunWith(Theories.class)
class Test {
    // this can probably be array of arrays instead
    @Datapoints
    public static List<List> = Arrays.asList{
        Arrays.asList(Arrays.asList(A.class), 
                      Arrays.asList(String.class, String.class),  
                      Arrays.asList(field1, field2)), 
        Arrays.asList(Arrays.asList(B.class), 
                      Arrays.asList(String.class, String.class, String.class),
                      Arrays.asList(field1, field3, field4)) 
    };

    @Theory
    public void test(List l) {
        Class<?> c = Class.forName(l.get(0).get(0).toString());
        Class[] types = (Class[]) l.get(1).toArray();
        Object[] args = l.get(2).toArray();


        T t = (T) c.getConstructor(types).newInstance(args);

        //do whatever with t
    }
}