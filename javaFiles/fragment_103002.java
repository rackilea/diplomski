Function<Foo, Item> f = 
    new Function<Foo, Item>() { 
        public Item apply(Foo foo) { return foo.getItem(); }
    };

Collection<Item> items = Collections2.transform(foos, f);