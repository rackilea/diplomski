public class PojoTest {

public int a;
public int b;
public int c;

private Map<String, Setter> setters = new HashMap<String, Setter>();

public PojoTest() {
initSetters();
}

public void set(Map<String, Integer> map) {
for (String s : map.keySet()) {
    setField(s, map.get(s));
}
}

public String toString() {
return a + ", " + b + ", " + c;
}

public static void main(String[] args) {
PojoTest t = new PojoTest();
Map<String, Integer> m = new HashMap<>();
m.put("a", 1);
m.put("b", 2);
m.put("c", 3);

t.set(m);

System.out.println(t);
}

private void setField(String s, Object o) {
setters.get(s).set(o);
}

private void initSetters() {
setters.put("a", new Setter() {
    @Override
    public void set(Object o) {
    a = (Integer) o;
    }
});

setters.put("b", new Setter() {
    @Override
    public void set(Object o) {
    b = (Integer) o;
    }
});

setters.put("c", new Setter() {
    @Override
    public void set(Object o) {
    c = (Integer) o;
    }
});
}

private static interface Setter {

public void set(Object o);
}

}