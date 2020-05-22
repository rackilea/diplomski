int [] dig = {0,2,2,2,0,0,0,0,0,0};

Set<Integer> set = new HashSet<>();

for (int d : dig)
{
    if (d != 0)
        set.add(d);
}

// check for less than 2 since 1=only 1 val, and 0=no values other than 0
if (set.size() < 2)
    System.out.println("All values are the same");
else
    System.out.println("Not all values are the same");