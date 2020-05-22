List<Object> allObjs = new ArrayList<>(); // Used to prevent GC
Set<Integer> hashes = new HashSet<Integer>(1024);

int colls = 0;
for (int n = 0; n < 100000; n++)
{
    Integer obj = new Integer(88);
    allObjs.add(obj); // keep a strong reference to prevent GC
    int ihash = System.identityHashCode(obj);
    Integer iho = Integer.valueOf(ihash);
    if (hashes.contains(iho))
    {
        System.err.println("System.identityHashCode() collision!");
        colls++;
    }
    else
    {
        hashes.add(iho);
    }
}

System.out.println("created 100000 different objects - "
        + colls
        + " times with the same value for System.identityHashCode()");

System.out.println("Size of all objects is " + allObjs.size());
System.out.println("Size of hashset of hash values is " + hashes.size());