ArrayList<ArrayList<HashSet<Integer>>> pn = new ArrayList<ArrayList<HashSet<Integer>>>();

for (int x = 0; x < 9; x++) 
{
    pn.add(x, new ArrayList<HashSet<Integer>>());

    for (int y = 0; y < 9; y++) {
        pn.get(x).add(y, new HashSet<Integer>());
        pn.get(x).get(y).add(new Integer(x));
    }
}


for (Integer i: pn.get(8).get(8))
{
    System.out.println(i);
}