Map m = new WeakHashMap();
    m.put(new Object(), 1);       // key is referenced only by map itself
    System.out.println(m.size()); // prints 1
    System.gc();     
    Thread.sleep(1); // give GC some time
    System.out.println(m.size()); // prints 0