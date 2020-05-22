class MyObject{

public Integer a;
public Integer b;
public Integer c;
}

public class Reflect {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        // TODO Auto-generated method stub
        MyObject a = new MyObject();
        a.a=4;
        MyObject b = new MyObject();
        b.a=2;
        b.b=3;
        b.c=5;
        GenericInstancePopulateMethod(MyObject.class, a, b);

        System.out.println(a.b);//this prints 3 as expected
        System.out.println(a.a);//this prints 4 as expected
    }
    static void GenericInstancePopulateMethod(Class<MyObject> clz, MyObject a, MyObject b) throws IllegalArgumentException, IllegalAccessException{

        Field[] fields = clz.getFields();

        for(Field f : fields){
        if(f.get(a) == null)
            f.set(a,  f.get(b)) ;//a fields  are assigned b fields' values
        }
    }
}