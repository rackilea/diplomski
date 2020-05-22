HashMap<?, ?> m1 = new HashMap<Object, Object>();
m1.put("foo", "bar");    // ERROR!!

HashMap<Object, Object> m2 = new HashMap<Object, Object>();
m2.put("foo", "bar");    // OK

HashMap m3 = new HashMap<Object, Object>();
m3.put("foo", "bar");   // WARNING (should be parameterized)