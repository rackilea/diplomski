UnifiedSet<Integer> pool = UnifiedSet.newSet();

Integer integer = 1;
pool.add(integer);

Assert.assertSame(integer, pool.get(new Integer(integer)));