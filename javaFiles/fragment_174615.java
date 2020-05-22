Set<Integer> s1 = new TreeSet<Integer>();
s1.add(1);
s1.add(2);
s1.add(6);

Set<Integer> s2 = new TreeSet<Integer>();
s2.add(2);
s2.add(6);

s2.retainAll(s1);

for (Integer i: s2)
{
    System.out.println(i);
}