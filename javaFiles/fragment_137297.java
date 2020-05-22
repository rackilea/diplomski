class FooDoer {
    // removed! using synchronized methods instead
    //final Object foolock = new Object();

    synchronized void foo() {

    }
}

// thread 1 - attacker
FooDoer f = new FooDoer();
globalMap.put("TheFoo",f);
synchronized(f) {
    while(true); // haha!
}

// thread 2 - victim
FooDoer f = globalMap.get("TheFoo");
f.foo(); // locked, because Thread 1 has locked us out!