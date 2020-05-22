public final class MyImmutableClass {
private MyImmutableClass(){}
private final String string;
private static Map<String,MyImmutableClass> map = new WeakHashMap<String,MyImmutableClass>();
public static final MyImmutableClass getInstance(String s) {

    if(map.containsKey(s))
        return (map.get(s));
    else{
        MyImmutableClass temp = new MyImmutableClass(s);
        map.put(s,temp);
        return  temp;
    }
}  

...

}