public static void main(String[] args) {

MyClass a=new MyClass(5);
MyClass b =new MyClass(7);
MyClass c =new MyClass(10);

MyClass result=c.closerTo(a,b);

}

interface Closer<T> {
 T closerTo(T t1,T t2);
}

class MyClass implements Closer<MyClass>{

private Integer num;

public MyClass(Integer n) {
 num=n;
}

@Override
public MyClass closerTo(MyClass t1, MyClass t2) {

 Integer diff1=num-t1.num;
 Integer diff2=num-t2.num;
 return diff1<diff2?t1:t2;

 }

}