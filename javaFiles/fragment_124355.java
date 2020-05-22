synchronized(grownSeedXYList) {
    Iterator i = grownSeedXYList.iterator();
    while (i.hasNext())
        foo(i.next());
    }
}