HashSet<Integer> set = new HashSet<Integer>();
set.add(1);

if (set.size() == 1) { // make sure that there is only one element in set
    Integer value = set.toArray(new Integer[1])[0];
    System.out.println(value);//output 1
}